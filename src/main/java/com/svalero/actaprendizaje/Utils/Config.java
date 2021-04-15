package com.svalero.actaprendizaje.Utils;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("API de Parques Nacionales y Naturales de España")
                        .description("Descripcion de los sectores con sus rutas")
                        .contact(new Contact()
                                .name("Clara Fdez")
                                .email("a24365@svalero.com"))
                        .version("1.0"));
    }

}
