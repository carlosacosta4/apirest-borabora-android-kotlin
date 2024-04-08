package pe.borabora.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import pe.borabora.security.filter.JwtTokenValidator;
import pe.borabora.service.impl.UserDetailServiceImpl;
import pe.borabora.util.JwtUtils;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtUtils jwtUtils;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationProvider authenticationProvider) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                	
                    // EndPoints publicos
                    http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();

                    http.requestMatchers(HttpMethod.GET, "/categories/**").permitAll();
                    http.requestMatchers(HttpMethod.GET, "/brand/**").permitAll();
                    http.requestMatchers(HttpMethod.GET, "/products/topSelling").permitAll();

                    //EndPoints Privados
                    http.requestMatchers(HttpMethod.GET, "/user/findUser/{}").hasAnyRole("USER", "ADMIN_BASIC", "ADMIN_FULL");
                    http.requestMatchers(HttpMethod.PUT, "/user/updateUser/{}").hasAnyRole("USER", "ADMIN_FULL");
                    http.requestMatchers(HttpMethod.POST, "/purchases/**").hasAnyRole("USER");
                    http.requestMatchers(HttpMethod.POST, "/categories/createCategory").hasAnyRole("ADMIN_BASIC");
                    http.requestMatchers(HttpMethod.PUT, "/categories/update/{idCategoria}").hasAnyRole("ADMIN_BASIC");
                    http.requestMatchers(HttpMethod.DELETE, "/categories/delete/{id}").hasAnyRole("ADMIN_BASIC");
                    http.requestMatchers(HttpMethod.POST, "/products/createProduct").hasAnyRole("ADMIN_BASIC");
                    http.requestMatchers(HttpMethod.PUT, "/products/update/{id}").hasAnyRole("ADMIN_BASIC");
                    http.requestMatchers(HttpMethod.DELETE, "/products/delete/{id}").hasAnyRole("ADMIN_BASIC");
                    http.requestMatchers(HttpMethod.GET, "/products/all").hasAnyRole("ADMIN_BASIC", "ADMIN_FULL");
                    http.requestMatchers(HttpMethod.GET, "/products/{productId}").hasAnyRole("ADMIN_BASIC", "ADMIN_FULL");

                    http.anyRequest().denyAll();
                })
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .exceptionHandling(exception -> exception.accessDeniedHandler(new CustomAccessDeniedHandler()))
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
