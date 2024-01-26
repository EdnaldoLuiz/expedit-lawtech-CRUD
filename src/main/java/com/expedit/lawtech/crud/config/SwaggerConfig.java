package com.expedit.lawtech.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        .info(new Info()
        .title("Lawtech CRUD API")
        .description("Desafio Rest API")
        .contact(new Contact()
        .name("Lawtech")
        .email("lawtech@gmail.exemplo"))
                .license(new License()
                .name("MIT")));
    }
}
