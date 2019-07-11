package com.hackfse.giveaway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.hackfse.giveaway.services.WebServiceUserService;
import com.hackfse.giveaway.util.Constants;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	WebServiceUserService wsUserService;

	@Autowired
	protected void configureGlobal(final AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.userDetailsService(wsUserService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new CustomFilterForCorsProtocol(), ChannelProcessingFilter.class);
		http
	      .csrf().disable()
	      .authorizeRequests().anyRequest().authenticated()
	      .and().httpBasic()
	      .and().sessionManagement().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, Constants.ALL_URL_PATTERN);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
