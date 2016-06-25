package com.ceit.ebs.cn.test.entity;

import java.io.Serializable;

import com.ceit.common.entity.BaseEntity;

public class Test extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 3023015298427553346L;
	
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
