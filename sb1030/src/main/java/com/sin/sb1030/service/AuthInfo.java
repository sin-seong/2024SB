package com.sin.sb1030.service;

public class AuthInfo {

	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	private Long id;
	private String email;
	private String name;
	
	public AuthInfo(Long id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}
	
}
