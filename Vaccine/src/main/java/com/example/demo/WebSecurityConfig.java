package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailService userDetailService;	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/detailCondition").permitAll()
				.antMatchers("/detailRegister").permitAll()
				.antMatchers("/userRegister").permitAll()
				.antMatchers("/resources/", "/static/","/webjars/**", "/css/**").permitAll()
				.anyRequest().hasAuthority("USER")
	            .and()
			.formLogin()
				.loginPage("/userLogin").permitAll()
				.loginProcessingUrl("/performUserLogin")
				.failureUrl("/userLogin?error=loginError")
				.defaultSuccessUrl("/detailCondition")
			    .usernameParameter("pid")
			    .passwordParameter("password")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/403");
	}
}