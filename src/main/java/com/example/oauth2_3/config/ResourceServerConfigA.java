package com.example.oauth2_3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 토큰을 확인할 리소스 서버
 * @EnableResourceServer 은 deprecated 되어
 * 시큐리티에서 직접 구성 메서드를 이용하도록 권장하고 있긴 함
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigA {
}
