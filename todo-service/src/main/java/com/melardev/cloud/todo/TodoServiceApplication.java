package com.melardev.cloud.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TodoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoServiceApplication.class, args);
    }

}
