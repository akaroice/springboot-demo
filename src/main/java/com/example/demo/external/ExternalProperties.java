package com.example.demo.external;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akaroice on 2018. 1. 12..
 */
@Setter
@Getter
@Component
@ConfigurationProperties("external.server")
public class ExternalProperties {
	private String rootUrl;
}
