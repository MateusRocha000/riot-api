package br.com.riot.api.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-Riot-Token", "RGAPI-4ed60161-fd48-4b4f-a35f-786fdc0fe659");
        };
    }
}
