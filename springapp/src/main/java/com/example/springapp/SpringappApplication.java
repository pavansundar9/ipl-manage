package com.example.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringappApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringappApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Redirect all unmatched routes to index.html
        registry.addViewController("/{spring:[^\\.]*}").setViewName("forward:/index.html");
    }
}
