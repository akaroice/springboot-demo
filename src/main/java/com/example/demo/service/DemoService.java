package com.example.demo.service;

import com.example.demo.domain.Demo;
import com.example.demo.domain.DemoProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by coupang on 2018. 1. 11..
 */
@Slf4j
@Service
public class DemoService {
	@Autowired
	private DemoProperties demoProperties;

	public Demo defaultDemo() {
		Demo demo = new Demo();
		demo.setName(demoProperties.getName());
		demo.setVersion(demoProperties.getVersion());
		log.info("demo called");
		return demo;
	}
}
