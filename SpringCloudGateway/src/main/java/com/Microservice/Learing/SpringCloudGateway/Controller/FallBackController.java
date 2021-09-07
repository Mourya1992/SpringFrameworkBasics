package com.Microservice.Learing.SpringCloudGateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@GetMapping("/fallback/message")
	
	public String getFallbackMesssage() {
		
		return "Server is under maintaince ,Please try after sometime";
	}

}
