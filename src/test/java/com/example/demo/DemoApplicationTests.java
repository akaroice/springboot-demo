package com.example.demo;

import com.example.demo.domain.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("Hello World!");
	}

	@Test
	public void demoRedis() {
		List<Demo> body = this.restTemplate.getForObject("/demoRedis", List.class);
		assertThat(body.get(0)).isEqualTo("{\"name\":\"developDemoName\",\"version\":\"developVersionProperties\"}");
	}
}
