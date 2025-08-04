package br.com.riot.api.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiotClientConfig {

    @Value("${api.api-key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        System.out.println(apiKey);
        return requestTemplate -> requestTemplate.header("X-Riot-Token", apiKey);
    }
}
