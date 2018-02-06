package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akaroice on 2018. 1. 12..
 */
@Setter
@Getter
public class CacheRedisProperties {
	private long defaultExpireTime = 0L;
	private Map<String, Long> expireTime = new HashMap<>();
}
