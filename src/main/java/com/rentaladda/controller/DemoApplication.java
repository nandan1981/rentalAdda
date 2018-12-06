package com.rentaladda.controller;

import com.rentaladda.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.core.JmsTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
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
        User use = new User("NalinBakshi");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        byte[] yourBytes;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(use);
            out.flush();
            yourBytes = bos.toByteArray();
            jms.convertAndSend("rentalQueue",yourBytes);
        } catch(IOException io){

            System.out.println("An issue with the input"+io.getCause());
            System.out.println("An issue with the input"+io.toString());
            System.out.println("An issue with the input"+io.getStackTrace());

        } finally{
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }




    }
}
