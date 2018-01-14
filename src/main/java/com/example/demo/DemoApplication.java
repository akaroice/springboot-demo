package com.example.demo;

import com.example.demo.config.CustomConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
@Import(CustomConfiguration.class)
public class DemoApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.listeners(new SpringEventListner())
			.sources(DemoApplication.class)
			.run(args);
//		SpringApplication.run();
	}
}
