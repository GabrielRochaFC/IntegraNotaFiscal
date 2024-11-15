package br.com.rasmoo.integranf.infra.security;

import br.com.rasmoo.integranf.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

// Filtro que acontece antes de UsernamePasswordAuthenticationFilter
@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Vamos recuperar o token
        var token = this.recoverToken(request);

        // Caso não seja nulo
        if (Objects.nonNull(token)) {
            // Usando token service, pegamos o subject
            var subject = tokenService.validateToken(token);
            UserDetails user = userRepository.findByEmail(subject);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // Se for nulo pode passar e ir fazer o próximo filtro
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {

        // Pegamos o header authorization
        var authHeader = request.getHeader("Authorization");

        // Verificamos se é nulo
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }

        // Retornamos ele
        return authHeader.replace("Bearer ", "");

    }
}
