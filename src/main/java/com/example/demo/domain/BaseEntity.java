package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by akaroice on 2018. 1. 11..
 */

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
	@CreatedBy
	@Column(name = "created_by", nullable = false, length = 100)
	private String createdBy;

	@CreatedDate
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@LastModifiedBy
	@Column(name = "modified_by", length = 100)
	private String modifiedBy;

	@LastModifiedDate
	@Column(name = "modified_at")
	private Date modifiedAt;
}
