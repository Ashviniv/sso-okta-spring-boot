package com.demo;//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.demo")
@EntityScan("com.demo")
@EnableAutoConfiguration
public class samlBlogApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(samlBlogApp.class).run(args);
    }


}
