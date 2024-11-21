package br.com.rasmoo.integranf.infra.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Integra NF API",
                version = "${api.version}",
                contact = @Contact(
                        name = "Rasmoo", email = "contato@rasmoo.com", url = "https://www.rasmoo.com"
                ),
                license = @License(
                        name = "MIT", url = "https://opensource.org/licenses/MIT"
                ),
                description = "Integra NF Microservice"
        ),
        security = {@SecurityRequirement(name = "Bearer Authentication")
        }
)
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {

}
