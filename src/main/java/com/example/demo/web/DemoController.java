package com.example.demo.web;

import com.example.demo.domain.Demo;
import com.example.demo.service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * Created by coupang on 2018. 1. 11..
 */
@RestController
public class DemoController {
	@Autowired
	private DemoService demoService;
	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping("/demo")
	public Demo hello() {
		return demoService.defaultDemo();
	}

	@RequestMapping("/demomap")
	public String helloMapper() throws JsonProcessingException {
		return objectMapper.writeValueAsString(demoService.defaultDemo());
	}
}
