package br.com.rasmoo.integranf.infra.security;

import br.com.rasmoo.integranf.exception.TokenException;
import br.com.rasmoo.integranf.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    // Pega o valor de application.properties
    @Value("${api.security.token.secret}")
    private String secret;

    // Metodo para gerar o token
    public String generateToken(User user) {
        try {
            // Usando esse algoritmo
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("integra-nf-api") // Quem está gerando
                    .withSubject(user.getEmail()) // Usuário
                    .withExpiresAt(getExpiresAt()) // Tempo de expiração
                    .sign(algorithm); // O algoritmo de geração
        } catch (JWTCreationException exception) { // Pode acontecer um erro na geração, então devemos tratar isso
            throw new TokenException("Error while generating token"); // Criei essa classe personalizada
        }
    }
    // Iremos validar o token e retornar o usuário que está registrado nesse token
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("integra-nf-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch ( JWTVerificationException exception ) {
            return "";
        }
    }

    // Metodo para gerar o tempo de expiração
    private static Instant getExpiresAt() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
