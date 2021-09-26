package com.flamingo.tacocloudreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudReactiveApplication {

	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(TacoCloudReactiveApplication.class);
//		application.setWebApplicationType(WebApplicationType.REACTIVE);
		SpringApplication.run(TacoCloudReactiveApplication.class, args);
	}

}
