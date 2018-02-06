package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by akaroice on 2018. 1. 11..
 */

@Getter
@Setter
@ToString
public class Demo implements Serializable {
	private String name;
	private String version;
}
