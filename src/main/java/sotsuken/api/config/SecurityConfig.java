package sotsuken.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/auth/userinfo").authenticated()
                        .requestMatchers("/api/student/**").hasRole("STUDENT")
                        .requestMatchers("/api/student/register", "/api/student/classes").permitAll()
                        .requestMatchers("/api/teachers/**").hasRole("TEACHER")
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/swagger-ui.html").permitAll()
                        .requestMatchers("/swagger-resource/**").permitAll()
                        .anyRequest().authenticated()) // denyAllにすると、正しくレスポンスボディが返却されない問題
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.NEVER))
                .authenticationProvider(new DaoAuthenticationProvider())
                .requestCache(cache -> cache
                        .requestCache(new NullRequestCache()))
                .httpBasic(basic -> basic.disable())
                .formLogin(form -> form.disable());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider(passwordEncoder);
        dao.setUserDetailsService(userDetailsService);
        return new ProviderManager(dao);
    }
}
