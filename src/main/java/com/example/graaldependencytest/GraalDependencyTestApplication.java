package com.example.graaldependencytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // (proxyBeanMethods = false) (macht keinen Unterschied)
public class GraalDependencyTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraalDependencyTestApplication.class, args);
    }
}
