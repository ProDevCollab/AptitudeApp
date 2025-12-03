package com.javaProject.AptitudeApp;

import com.javaProject.AptitudeApp.service.tempAddData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AptitudeAppApplication {

	public static void main(String[] args) {
        SpringApplication.run(AptitudeAppApplication.class, args);
        //container.getBean(tempAddData.class).addData();
	}

}
