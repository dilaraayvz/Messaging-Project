package com.messaging_app.authserver;

import com.messaging.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSecurity // core paket için gerekli anotasyon
public class AuthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserverApplication.class, args);
	}

}
