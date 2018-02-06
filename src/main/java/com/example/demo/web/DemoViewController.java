package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by akaroice on 2018. 1. 11..
 */
@Controller
public class DemoViewController {
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/demoView")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
}
