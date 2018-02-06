package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by akaroice on 2018. 1. 11..
 */

@Getter
@Setter
@Component
@ConfigurationProperties(prefix="demo")
public class DemoProperties {
	private String name;
	private String version;
}
