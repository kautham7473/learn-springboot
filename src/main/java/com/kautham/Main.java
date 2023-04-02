package com.kautham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@SpringBootApplication
@ComponentScan(basePackages = "com.kautham")
@EnableAutoConfiguration
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse("Hello",
                List.of("Java", "Python", "JS", "Angular"),
                new Person("Kautham", 21, 30_000)
        );
        return response;
    }

    record Person(String name, int age, double savings){}
    record GreetResponse(
            String greet,
            List<String> favoriteLang,
            Person person
            ){}

}
