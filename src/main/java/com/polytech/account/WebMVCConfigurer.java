package com.polytech.account;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by guzzi on 17/03/2017.
 */

	@Configuration
	public class WebMVCConfigurer extends WebMvcConfigurerAdapter {


		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login").setViewName("login");
			registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		}
	}