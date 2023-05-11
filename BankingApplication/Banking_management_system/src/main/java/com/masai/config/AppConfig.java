package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig {

	/**
	 * This function configures the Spring Security filter chain for a Java application, including session
	 * management, CSRF protection, request authorization, and JWT token generation and validation.
	 * 
	 * @param http The HttpSecurity object used to configure Spring Security.
	 * @return A SecurityFilterChain object is being returned.
	 */
	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {

		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/customers").permitAll()
		.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
		.anyRequest().authenticated().and()
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and()
		.httpBasic();

		return http.build();

	}

	/**
	 * This function returns a BCryptPasswordEncoder object used for password encoding in Java.
	 * 
	 * @return A new instance of the BCryptPasswordEncoder class, which is a PasswordEncoder used for
	 * encoding and decoding passwords using the BCrypt hashing algorithm.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

}
