package com.proplant.backend.api_wide_pack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public SecurityConfig(UserDetailsService userDetailsService,
	 					  BCryptPasswordEncoder bCryptPasswordEncoder) {
						  this.userDetailsService = userDetailsService;
						  this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
	http.csrf().disable();
	http.headers().frameOptions().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    http.authorizeRequests().antMatchers("/login/**","/user/**").permitAll();
	//les routes specifiées

	//ressource                                                                      
	 http.authorizeRequests().antMatchers("/ressource/**").permitAll();
	 /* http.authorizeRequests().antMatchers(HttpMethod.POST, "/ressource/**").hasAuthority("ADMIN");
	 http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/ressource/**").hasAuthority("ADMIN");
	 http.authorizeRequests().antMatchers(HttpMethod.PUT, "/ressource/**").hasAuthority("ADMIN");*/
	 
	 //chech authenticated after
	 http.authorizeRequests().anyRequest().authenticated();

	 //all filter
	 http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	 http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
}
