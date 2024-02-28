package com.prototype.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity 
public class AuthorizeUrlsSecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean	
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return  provider;
	}
	
	   @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        
	    	http
	    	.csrf((csrf) -> csrf.disable())
	    	
	       	.authorizeHttpRequests((authorizeHttpRequests) ->
				authorizeHttpRequests
				.requestMatchers("/api/register**","/api/registerApp**","/api/query","/api/qwt**","/api/plsa**")
				.permitAll()
				.anyRequest()
				.authenticated()
			)
	    	
      	
	       	.formLogin((formLogin) ->
				formLogin
			.loginProcessingUrl("/api/login")
			.defaultSuccessUrl("/api/success", true) 
	  		.permitAll()                                                                                                                                           
	  		.failureUrl("/api/failed"))
	       	.logout((logout) ->
				logout
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
				.logoutSuccessUrl("/api/logout-success")
				.permitAll()
			);
    	
		return http.build();

	    }      
 }