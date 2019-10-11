package io.github.wellingtoncosta.sescomp.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CustomerServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApp.class, args);
    }

}
