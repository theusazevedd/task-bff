package com.azevedo.task_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaskBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskBffApplication.class, args);
	}

}
