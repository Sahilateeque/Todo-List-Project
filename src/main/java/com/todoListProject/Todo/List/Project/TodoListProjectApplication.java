package com.todoListProject.Todo.List.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
public class TodoListProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListProjectApplication.class, args);
	}
	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

}
