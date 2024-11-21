package com.accepted_example.matches.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Localhost");

        Contact myContact = new Contact();
        myContact.setName("Andreas Filippatos");
        myContact.setEmail("afilippatos85@gmail.com");

        Info information = new Info()
                .title("ACCEPTED - Match and Match Odds API")
                .version("0.0.1-SNAPSHOT")
                .description("This API exposes endpoints to matches and match odds.")
                .contact(myContact);

        return new OpenAPI().info(information).servers(List.of(server));
    }

}
