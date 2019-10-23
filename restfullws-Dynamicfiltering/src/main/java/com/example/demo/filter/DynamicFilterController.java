package com.example.demo.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilterController {
	
	@GetMapping("/filterting")
	public MappingJacksonValue userList() {
		List<UserFilter> userList = Arrays.asList (new UserFilter("nnr", "test123"),
				new UserFilter("mx","test456"));
		
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("password");
		FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		MappingJacksonValue mappingValue= new MappingJacksonValue(userList);
		mappingValue.setFilters(filters);
		
		
		
		return  mappingValue;
	}

	
	
	@GetMapping("/filterning-one")
	public MappingJacksonValue user() {
		UserFilter userFilter = new UserFilter("max", "test123");
		
		MappingJacksonValue mappingValue= new MappingJacksonValue(userFilter);
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("username");
		FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		mappingValue.setFilters(filters);
		
		return  mappingValue;
	}
}
