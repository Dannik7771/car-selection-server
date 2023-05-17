package com.ostdan.carselectionserver.documentation

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition
class SwaggerConfigurer {
    @Bean
    fun configure(): OpenAPI {
        return OpenAPI().info(Info().title("Car Selection API").version("0.0.1").description("Documentation for Car Selection API"))
    }
}