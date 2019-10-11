package io.github.wellingtoncosta.sescomp.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BookServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApp.class, args);
    }

}
