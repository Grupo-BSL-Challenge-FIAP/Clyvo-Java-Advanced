package br.com.clyvo.petguardian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PetguardianApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetguardianApplication.class, args);
	}

}
