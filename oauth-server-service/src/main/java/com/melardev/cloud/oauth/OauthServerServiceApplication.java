package com.melardev.cloud.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OauthServerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerServiceApplication.class, args);
    }

}
