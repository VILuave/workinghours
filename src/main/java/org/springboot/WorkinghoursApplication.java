package org.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WorkinghoursApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkinghoursApplication.class, args);
    }
}
