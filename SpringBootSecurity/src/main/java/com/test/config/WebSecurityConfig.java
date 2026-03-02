package com.test.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails user = User.builder().username("USER").password(passwordEncoder().encode("123")).roles("USER").build();
		
		UserDetails admin = User.builder().username("ADMIN").password(passwordEncoder().encode("1234")).roles("ADMIN", "USER").build();

		UserDetails HR = User.builder().username("HR").password(passwordEncoder().encode("12345")).roles("HR").build();
		
		UserDetails emp = User.builder().username("EMPLOYEE").password(passwordEncoder().encode("123456")).roles("HR", "EMPLOYEE").build();

		return new InMemoryUserDetailsManager(user, admin,emp, HR);
		
	} 
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) {
		return http.csrf(AbstractHttpConfigurer :: disable).authorizeHttpRequests(
				request -> request.requestMatchers("/login").permitAll().requestMatchers("/")
				.hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "ROLE_HR", "ROLE_EMPLOYEE")
				.requestMatchers("/user/read")
				.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
				.requestMatchers("/user/hr/**")
				.hasAnyAuthority("ROLE_HR", "ROLE_EMPLOYEE", "ROLE_ADMIN").anyRequest()
				.authenticated())
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error=true").permitAll())
				.logout(config -> config.logoutUrl("/logout").logoutSuccessUrl("/login")).build();
	}
}
