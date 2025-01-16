package com.example.compuservicessoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CompuServicesSoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompuServicesSoftApplication.class, args);
    }


    @Configuration
    public static class Myconfiguration {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOrigins("https://compuservicessoft.com") // Tu dominio
                            .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
                            .allowedHeaders("*") // Puedes especificar headers si prefieres mayor control
                            .allowCredentials(true); // Habilita credenciales (si usas sesiones o cookies)
                }
            };
        }
    }

}
