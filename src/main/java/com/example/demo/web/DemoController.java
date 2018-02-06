package com.example.demo.web;

import com.example.demo.domain.Demo;
import com.example.demo.external.ExternalService;
import com.example.demo.service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * Created by akaroice on 2018. 1. 11..
 */
@RequestMapping("/api")
@RestController
public class DemoController {
	@Autowired
	private DemoService demoService;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ExternalService externalService;

	@RequestMapping("/demo")
	public Demo demo(@RequestParam(required = false) String name) {
		if (Objects.isNull(name)) {
			return demoService.defaultDemo();
		} else {
			return demoService.cachedDefaultDemo(name);
		}
	}

	@RequestMapping("/demoRedis")
	public List<Demo> demoRedis() {
		return demoService.addAndGet();
	}

	@RequestMapping("/demoCache")
	public Demo demoCache(@RequestParam(defaultValue = "defaultName") String name) {
		return demoService.cachedDefaultDemo(name);
	}

	@RequestMapping("/demoCacheEvict")
	public Demo demoCacheEvict(@RequestParam(defaultValue = "defaultName") String name) {
		return demoService.cachedEvictDemo(name);
	}

	@RequestMapping("/demoMap")
	public String helloMapper() throws JsonProcessingException {
		return objectMapper.writeValueAsString(demoService.defaultDemo());
	}

	@RequestMapping("/demoExternal")
	public Demo demoExternal() {
		return externalService.call("external");
	}
}
