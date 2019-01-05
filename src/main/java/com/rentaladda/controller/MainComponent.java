package com.rentaladda.controller;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.rentaladda")
public class MainComponent {

    public static String createEmailID(String firstPart, String secondPart){
        String generatedId = firstPart+"."+secondPart+"@testdomain.com";
        return generatedId;
    }

/*    @Bean
    public Bean getViewBean(){

    }*/
}
