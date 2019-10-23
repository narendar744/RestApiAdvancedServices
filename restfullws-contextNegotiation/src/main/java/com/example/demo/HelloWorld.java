package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@GetMapping(path="/hello")
	public String show() {
		return "hello";
	}
	@GetMapping(path="/hello-bean")
	public HelloBean showBean() {
		return new HelloBean("narendar");
	}
	@GetMapping(path="/hello-bean/{name}")
	public HelloBean showBeanwithName(@PathVariable("name") String name) {
		return new HelloBean(String.format("hello %s,%s",name,name));
	}
}
