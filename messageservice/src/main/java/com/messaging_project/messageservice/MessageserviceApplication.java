package com.messaging_project.messageservice;

import com.messaging.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableSecurity // core paket için gerekli anotasyon

public class MessageserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageserviceApplication.class, args);
	}

}
