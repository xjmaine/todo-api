package io.api.todo.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI SprinDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Todo API")
                        .version("1.0")
                        .description("Todo Application API"))
                        .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                        .components(new Components()
                                .addSecuritySchemes("basicAuth", new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic")));
    }
}