package com.hyundaiite.jarvis;

import com.hyundaiite.jarvis.controller.TestCtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JarvisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JarvisApplication.class, args);
    }

}
