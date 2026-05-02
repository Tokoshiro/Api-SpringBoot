package com.gestion.eventos.api.security.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI()
                .info(new Info()
                        .title("Gestión de Eventos API")
                        .version("1.0")
                        .description("API RESTful para la gestión de eventos, categorías y ponentes")
                        .contact(new Contact()
                                .name("Gaaato")
                                .email("algo@email.com")
                                .url("tuURSL.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("apache.org/licenses/LICENSE-2.9.html")
                        )
                );

    }

}
