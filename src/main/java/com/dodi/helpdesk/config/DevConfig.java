package com.dodi.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dodi.helpdesk.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
//O @Value pega o valor da variável spring.jpa.hibernate.ddl-auto no application.properties
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	//@Bean
	public boolean instanciaDB() {
		
		if(value.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}
}
