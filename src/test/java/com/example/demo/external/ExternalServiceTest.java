package com.example.demo.external;

import com.example.demo.domain.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by akaroice on 2018. 1. 17..
 */
@RunWith(SpringRunner.class)
@RestClientTest(value = { ExternalService.class, ExternalProperties.class })
public class ExternalServiceTest {
	@Autowired
	private ExternalService externalService;
	@Autowired
	private MockRestServiceServer server;

	@Test
	public void test() {
		this.server.expect(requestTo("/demo?name=externalName"))
				.andRespond(withSuccess("{\"name\":\"developDemoName\",\"version\":\"developVersionProperties\"}", MediaType.APPLICATION_JSON));
		Demo demo = this.externalService.call("externalName");
		assertThat(demo.getName()).isEqualTo("developDemoName");
	}
}
