package org.itstep.chat.config;

import org.itstep.chat.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
//        return username -> {
//            try {
//                return userService.loadUserByUsername(username);
//            } catch (UsernameNotFoundException e) {
//                logger.error(e.getMessage());
//                throw e;
//            }
//        };
    }

    @Bean
    public SecurityFilterChain
    securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/register", "/login",
                                "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/profile", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL, по которому будет происходить logout
                        .logoutSuccessUrl("/login?logout=true") // Куда редиректить после logout
                        .invalidateHttpSession(true) // Инвалидация HTTP-сессии
                        .deleteCookies("JSESSIONID") // Удаление куков
                        .permitAll()
                );

        return http.build();

//        logger.info("Creating SecurityFilterChain in SecurityConfig");
//
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/register").permitAll()
//                        //.requestMatchers("/admin").hasRole("ADMIN")
//                        //.requestMatchers("/user")
//                        //.hasAnyRole("USER", "ADMIN")
//                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/"));
//
//        return http.build();
    }
}
