package com.example.Orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


//Adding loadBalanced on a RestTemplate enables client-side load balancing.
//It intercept the local service names and resolve them into actual instances URLs from Eureka


//Eureka Client > PRODUCT_SERVICE

//PRODUCT_SERVICE > [10.0.0.12:8080 , 10.0.0.13:8080 , 10.0.0.14:8080 , 10.0.0.15:8080 ]
//
//restTemplate.getForObject("http://PRODUCT-SERVICE/api/products/1", ProductDTO.class);
//
//PRODUCT_SERVICE > NOT A DNS name
//
//@LoadBalanced annotation contacts Eureka > fetch the available instances > picks one
//
//restTemplate.getForObject("http://10.0.0.13:8080/api/products/1", ProductDTO.class);

