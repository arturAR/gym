package com.java.academy.gym.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Rest config
 */
@Configuration
public class RestConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
