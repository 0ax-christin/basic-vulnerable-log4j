package com.heroes.api.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HeroesApiApplication extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(HeroesApiApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(HeroesApiApplication.class, args);
	}

}
