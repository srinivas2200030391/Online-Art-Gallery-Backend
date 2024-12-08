package com.klef.jfsd.OnlineArtGallery;

import com.klef.jfsd.OnlineArtGallery.controllers.DemoController;
import com.klef.jfsd.OnlineArtGallery.models.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//
//		try {
//			DemoController demoController = context.getBean(DemoController.class);
//
//			Map<String, String> adminCredentials = new HashMap<>();
//			adminCredentials.put("username","adminUsername");
//			adminCredentials.put("password","adminPassword");
//			demoController.signUpAdmin(adminCredentials);
//		} catch (Exception e) {
//			System.err.println("Error creating admin: " + e.getMessage());
//		}
	}
}