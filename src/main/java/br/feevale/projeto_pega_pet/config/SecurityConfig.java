package br.feevale.projeto_pega_pet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable);
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("*/*").permitAll()
//                        .requestMatchers("/cadastrar").permitAll()
//                        .requestMatchers("/login").permitAll()
//                        .requestMatchers("/usuario/*").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                    .loginPage("/login")
//                    .permitAll()
//                )
//                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
