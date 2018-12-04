package com.rentaladda.controller;

import com.rentaladda.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.core.JmsTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories("com.rentaladda.*")
@EntityScan("com.rentaladda.*")
@EnableAspectJAutoProxy
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);

        JmsTemplate jms = ctx.getBean(JmsTemplate.class);


        jms.convertAndSend("rentalQueue","Rana sixer boi hai");


    }
}
