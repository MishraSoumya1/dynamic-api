package com.json.dynamic_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
		info = @Info(title = "Dynamic Webhook API", version = "1.0", description = "Handles dynamic JSON payloads")
)
@SpringBootApplication
public class DynamicApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicApiApplication.class, args);
	}

}
