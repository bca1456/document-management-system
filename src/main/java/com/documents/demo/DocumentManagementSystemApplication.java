package com.documents.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DocumentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentManagementSystemApplication.class, args);


    }

}
