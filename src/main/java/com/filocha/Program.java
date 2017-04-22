package com.filocha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Program {

    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }
}
