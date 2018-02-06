package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by akaroice on 2018. 1. 11..
 */
@Slf4j
public class SpringEventListner implements ApplicationListener<ApplicationStartingEvent>{
	@Override public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("Spring Application starting");
		log.info("Spring Application starting");
	}
}
