package com.example.onlineshopping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/product/*")
                        .allowedOrigins("*");
                registry.addMapping("/product/productName/{searchTerm}")
                        .allowedOrigins("*");
                registry.addMapping("/cart/*")
                        .allowedOrigins("*");
                registry.addMapping("/cart/add/*")
                        .allowedOrigins("*");
                registry.addMapping("/cart/remove/*")
                        .allowedOrigins("*");
                registry.addMapping("/cart/order/{totalPrice}/{productList}")
                        .allowedOrigins("*");
            }
        };
    }
}

