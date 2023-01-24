package com.example.oauth2_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 데이터 소스를 주입하고 토큰 저장소를 구성하도록 변경
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfigB extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    // application.properties 에서 구성한 데이터 소스 주입
    private final DataSource dataSource;

    public AuthServerConfigB(AuthenticationManager authenticationManager, DataSource dataSource) {
        this.authenticationManager = authenticationManager;
        this.dataSource = dataSource;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                // 클라이언트 정보
                .withClient("client")
                .secret("secret")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("read")

        ;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                // 토큰 저장소 구성
                .tokenStore(tokenStore());
    }

    /**
     * application.properties 파일에 구성된 데이터 소스를 통해
     * DB 접근을 제공하는 jdbcTokenStore 인스턴스 생성
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

}
