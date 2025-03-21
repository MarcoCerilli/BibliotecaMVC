package biblioteca.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .requestMatchers("/", "/index", "/register", "/login", "/css/**", "/js/**").permitAll() // Permetti la home e login
	            .requestMatchers("/biblioteca/libri", "/biblioteca/libri/**").permitAll() // Permetti accesso libero alla lista libri
	            .anyRequest().authenticated() // Tutto il resto richiede login
	        .and()
	        .formLogin()
	            .loginPage("/login")
	            .defaultSuccessUrl("/", true) // Dopo login torna alla home
	            .permitAll()
	        .and()
	        .logout()
	            .logoutSuccessUrl("/") // Dopo logout torna alla home
	            .permitAll()
	        .and()
	        .csrf().disable(); // Disabilita CSRF se necessario

	    return http.build();
	}

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
