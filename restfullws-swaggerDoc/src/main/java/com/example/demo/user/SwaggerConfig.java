package com.example.demo.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	
	
	public static final Contact DEFAULT_CONTACT = new Contact("narendar", "https://github.com/narendar744", "narendar.as133@gmail.com");
	  public static final ApiInfo apiInfo = new ApiInfo("Narendar Documentation", "Narendar  Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
	          
	          new ArrayList<VendorExtension>());
	private static final Set<String> producesAndConsumers = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.produces(producesAndConsumers)
				.consumes(producesAndConsumers)
				;
		
	}

}
