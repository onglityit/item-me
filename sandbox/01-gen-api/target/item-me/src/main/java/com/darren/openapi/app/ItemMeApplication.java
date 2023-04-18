package com.darren.openapi.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@Configuration
public class ItemMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemMeApplication.class, args);
    }
}
