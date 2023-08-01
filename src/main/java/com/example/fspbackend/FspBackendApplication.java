package com.example.fspbackend;

import com.example.fspbackend.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({JwtProperties.class})
@SpringBootApplication
public class FspBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(FspBackendApplication.class, args);
	}
}
