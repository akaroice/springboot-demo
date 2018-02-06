package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by akaroice on 2018. 1. 11..
 */

@Setter
@Getter
@Entity
@Table(name = "demo")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString
public class DemoEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "version", nullable = false)
	private Long version;
}
