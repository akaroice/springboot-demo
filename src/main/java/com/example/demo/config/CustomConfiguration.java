package com.example.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by akaroice on 2018. 1. 12..
 */
@EnableCaching
@Configuration
public class CustomConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public ObjectMapper objectMapper() {
//		Mapper instances are fully thread-safe provided that ALL configuration of the
//		instance occurs before ANY read or write calls.
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		return objectMapper;
	}

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource dataSource(DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean
	@ConfigurationProperties("spring.cache.redis")
	public CacheRedisProperties cacheRedisProperties() {
		return new CacheRedisProperties();
	}

	@Bean
	public CacheManagerCustomizer<RedisCacheManager> cacheManagerCustomizer(CacheRedisProperties cacheRedisProperties) {
		return new CacheManagerCustomizer<RedisCacheManager>() {
			@Override
			public void customize(RedisCacheManager cacheManager) {
				cacheManager.setDefaultExpiration(cacheRedisProperties.getDefaultExpireTime());
				cacheManager.setExpires(cacheRedisProperties.getExpireTime());
			}
		};
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
}
