package com.example.demo.user.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.Name;
import com.example.demo.user.UserV1;
import com.example.demo.user.UserV2;

@RestController
public class UserVersionController {
	@GetMapping("/v1")
	public UserV1 versionOne() {
		return new UserV1("narendar reddy");
	}
	@GetMapping("v2")
	public UserV2 versionTwo() {
		return new UserV2(new Name("narendar reddy","naganolla"));
	}
	
	
	@GetMapping(value="/param",params="v1")
	public UserV1 paramOne() {
		return new UserV1("narendar reddy");//http://localhost:8080/param?v1
	}
	@GetMapping(value="/param",params="v2")
	public UserV2 paramTwo() {
		return new UserV2(new Name("narendar reddy","naganolla"));//http://localhost:8080/param?v2
	}
	
	/**
	 * 
	 * @use postman to check and send through header
	 */
	
	@GetMapping(value="/header",headers="API=1")
	public UserV1 headerOne() {
		return new UserV1("narendar reddy");
	}
	@GetMapping(value="/header",headers="API=2")
	public UserV2 headerTwo() {
		return new UserV2(new Name("narendar reddy","naganolla"));
	}
	
	
	/**
	 * 
	 * @use postman to check and send through header
	 * key=Accept
	 * 
	 */
	@GetMapping(value="/produces",produces="application/API-v1+json")
	public UserV1 producesOne() {
		return new UserV1("narendar reddy");
	}
	@GetMapping(value="/produces",produces="application/API-v2+json")
	public UserV2 producesTwo() {
		return new UserV2(new Name("narendar reddy","naganolla"));//use postman to check
	}
	

}
