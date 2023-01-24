package com.example.oauth2_3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 토큰을 확인할 리소스 서버
 * @EnableResourceServer 은 deprecated 되어
 * 시큐리티에서 직접 구성 메서드를 이용하도록 권장하고 있긴 함
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigB extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                // oauth2 리소스 서버 정보
                .oauth2ResourceServer(
                        c -> c.opaqueToken(
                                o -> {
                                    // check_token URI
                                    o.introspectionUri("_");
                                    o.introspectionClientCredentials("client", "secret");
                                }));
    }
}
