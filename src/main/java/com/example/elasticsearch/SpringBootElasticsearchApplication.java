package com.example.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
@SpringBootApplication
public class SpringBootElasticsearchApplication {
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticsearchApplication.class, args);
	}
}
