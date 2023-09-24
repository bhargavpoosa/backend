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
                registry.addMapping("/user/*")
                        .allowedOrigins("*");
                registry.addMapping("/admin/")
                        .allowedOrigins("*");
                registry.addMapping("/product/*")
                        .allowedOrigins("*");
                registry.addMapping("/product/productDetails/*")
                        .allowedOrigins("*");
                registry.addMapping("/product/productName/{searchTerm}")
                        .allowedOrigins("*");
                registry.addMapping("/cart/**")
                        .allowedOrigins("*");
//                        .allowedOriginPatterns("*")
//                        .allowCredentials(true)
//                        .maxAge(3600);
                registry.addMapping("/cart/add/*")
                        .allowedOrigins("*");
//                registry.addMapping("/cart/order")
//                        .allowedOrigins("*");
//                registry.addMapping("/cart/remove/*")
//                        .allowedOrigins("*");
//                registry.addMapping("/cart/order/{totalPrice}/{productList}")
//                        .allowedOrigins("*");
            }
        };
    }
}

