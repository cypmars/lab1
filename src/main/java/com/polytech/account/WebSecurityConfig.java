package com.polytech.account;

import com.polytech.account.repository.RoleRepository;
import com.polytech.account.repository.UserRepository;
import com.polytech.account.service.UserService;
import com.polytech.account.models.Role;
import com.polytech.account.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

/**
 * Created by guzzi on 17/03/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers( "/new_account").permitAll()
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login").permitAll()
			.and()
				.logout().permitAll()
			.and()
				.httpBasic()
			.and()
				.csrf().disable();
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user").password("pwd").roles("USER") ;

		User user = new User();
		user.setPassword("pwd");
		user.setPasswordConfirm(user.getPassword());
		user.setUsername("user");
		user.setRoles(new HashSet<Role>());
		user.getRoles().add(roleRepository.findAll().get(0));

		userService.save(user);
	}
}