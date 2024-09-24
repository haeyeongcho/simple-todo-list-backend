package org.example.simpletodolistbackend.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Simple Todo List API Documentation")
                .description("Simple Todo List 애플리케이션의 유저 관리 및 작업 관리를 위한 REST API 문서")
                .version("1.0.0");
    }
}
