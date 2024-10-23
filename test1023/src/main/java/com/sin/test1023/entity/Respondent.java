package com.sin.test1023.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Respondent {

	private int age;
	private String location;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
