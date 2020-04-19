package com.kidder.springBootStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.kidder.springBootStarter.Repo")
public class SpringBootStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SpringApplication.run(SpringBootStarter.class, args);
	}

}
