package com.vrtouristservice.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Tourist API")
                        .description("This is an api for tourists")
                        .termsOfService("terms of service")
                        .contact(new Contact().email("alexnewzniyo@gmail.com"))
                        .license(new License().name("VR v1"))
                        .version("1.0")
                );
    }
}
