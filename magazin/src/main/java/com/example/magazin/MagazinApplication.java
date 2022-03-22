package com.example.magazin;

import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.view.LoginView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MagazinApplication{

	public static void main(String[] args) {
		//SpringApplication.run(MagazinApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MagazinApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
