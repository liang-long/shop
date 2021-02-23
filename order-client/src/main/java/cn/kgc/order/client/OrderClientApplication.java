package cn.kgc.order.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderClientApplication {
    @Bean
    public RestTemplate newRestTemplate(RestTemplateBuilder templateBuilder) {
        return templateBuilder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderClientApplication.class, args);
    }

}
