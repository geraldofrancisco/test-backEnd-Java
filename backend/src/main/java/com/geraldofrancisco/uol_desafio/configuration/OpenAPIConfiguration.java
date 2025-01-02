package com.geraldofrancisco.uol_desafio.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Value("${app.version}")
    private String appVersion;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(getAppInfo());
    }

    private Info getAppInfo() {
        return new Info()
                .title("Service Pluggy")
                .description("API de comunicação com o serviço da Pluggy")
                .version(appVersion);
    }
}