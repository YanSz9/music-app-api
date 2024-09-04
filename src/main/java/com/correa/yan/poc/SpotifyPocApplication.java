package com.correa.yan.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpotifyPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyPocApplication.class, args);
	}

}