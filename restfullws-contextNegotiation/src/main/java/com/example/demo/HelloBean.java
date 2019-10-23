package com.example.demo;

public class HelloBean {
	private String name;

	public HelloBean(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloBean [name=" + name + "]";
	}
	

}
