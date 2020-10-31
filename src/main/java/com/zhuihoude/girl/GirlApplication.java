package com.zhuihoude.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }

}

//  maven 启动方式
//  mvn spring-boot:run

// mav install
// cd target
// java -jar xx.jar --spring.profiles.active: prod
