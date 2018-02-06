package com.example.demo.service;

import com.example.demo.domain.Demo;
import com.example.demo.domain.DemoProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by akaroice on 2018. 1. 11..
 */
@Slf4j
@Service
public class DemoService {
	@Autowired
	private DemoProperties demoProperties;
	@Autowired
	private StringRedisTemplate template;
	@Autowired
	private ObjectMapper objectMapper;

	public Demo defaultDemo() {
		Demo demo = new Demo();
		demo.setName(demoProperties.getName());
		demo.setVersion(demoProperties.getVersion());
		return demo;
	}

	@Cacheable(cacheNames = "demo")
	public Demo cachedDefaultDemo(String name) {
		Demo demo = new Demo();
		demo.setName(name);
		demo.setVersion(demoProperties.getVersion());
		log.info("cached default demo called");
		return demo;
	}

	@CacheEvict(cacheNames = "demo")
	public Demo cachedEvictDemo(String name) {
		log.info("cached default demo called");
		return cachedDefaultDemo(name);
	}

	public List<Demo> addAndGet() {
		List operationResults = this.template.execute(new SessionCallback<List>() {
			@Override
			public List execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				BoundListOperations<String, String> boundListOperations = operations.boundListOps(generateKey(1L));
				try {
					boundListOperations.leftPush(objectMapper.writeValueAsString(defaultDemo()));
				} catch (JsonProcessingException e) {
					throw new RuntimeException("convert to Json error");
				}
				boundListOperations.trim(0L, 3);
				boundListOperations.expire(60L, TimeUnit.SECONDS);
				boundListOperations.range(0, -1);

				return operations.exec();
			}
		});

		return (List<Demo>) operationResults.get(2);
	}

	private String generateKey(Long id) {
		return "demo:develop:" + id;
	}
}
