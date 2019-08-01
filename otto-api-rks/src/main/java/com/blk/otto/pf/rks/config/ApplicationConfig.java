package com.blk.otto.pf.rks.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	/**
	 * @return a modelmapper object in application contect
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
