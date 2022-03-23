package com.varun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"com.varun"})
@ComponentScan({ "com.varun.*" })
@EnableJpaRepositories("com.varun.repository")
@EntityScan("com.varun")
public class CrudApplication extends SpringBootServletInitializer {
	
	 @Override
	  
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	  {
	  
	  return application.sources(CrudApplication.class);
	  
	  }

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
