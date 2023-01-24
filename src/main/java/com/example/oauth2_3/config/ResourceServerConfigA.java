package com.example.oauth2_3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 토큰을 확인할 리소스 서버
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigA {
}
