package br.com.apipacientes.pacientesapi;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@SecurityScheme(
        name = "keycloak",
        type = SecuritySchemeType.OAUTH2, // Define o tipo geral como OAuth2
        flows = @OAuthFlows(
                // Define especificamente o fluxo de "Código de Autorização" (com redirecionamento)
                authorizationCode = @OAuthFlow(
                        // Pega a URL de autorização do application.properties
                        authorizationUrl = "${springdoc.swagger-ui.oauth.authorization-url}",
                        // Pega a URL de token do application.properties
                        tokenUrl = "${springdoc.swagger-ui.oauth.token-url}",
                        scopes = {}
                )
        )
)
public class PacientesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PacientesApiApplication.class, args);
    }
}

