package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by akaroice on 2018. 1. 12..
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
public class SecutiryConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/resources/**", "/signup", "/about", "/api/**").permitAll()
			.anyRequest().authenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin")
			.roles("ADMIN", "USER").and().withUser("user").password("user")
			.roles("USER");
	}
}
