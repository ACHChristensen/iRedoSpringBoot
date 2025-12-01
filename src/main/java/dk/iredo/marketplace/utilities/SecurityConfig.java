package dk.iredo.marketplace.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;
    private final Environment env;

    public SecurityConfig(Environment env, JwtAuthenticationFilter jwtFilter) {
        this.env = env;
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for APIs
            .csrf(csrf -> csrf.disable())

            // Enable CORS with custom configuration
            .cors(cors -> cors.configurationSource(request -> {
                var updatedCors = new org.springframework.web.cors.CorsConfiguration();
                updatedCors.setAllowedOrigins(java.util.List.of(env.getProperty("frontend.url"))); // your frontend
                updatedCors.setAllowedMethods(java.util.List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                updatedCors.setAllowedHeaders(java.util.List.of("*"));
                updatedCors.setAllowCredentials(true); // needed if using cookies, optional for JWT header
                return updatedCors;
            }))

            // Authorize requests
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // login open
                .requestMatchers("/listings/**").permitAll() // TODO - to change?
                .anyRequest().authenticated()           // everything else requires JWT
            )

            // Stateless session
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Add JWT filter before UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
