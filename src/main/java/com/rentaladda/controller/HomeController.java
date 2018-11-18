package com.rentaladda.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Controller
public class HomeController {

private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value="/home/{name}")
    public String Welcome(Model model, @PathVariable(value="name") String name){
        model.addAttribute("name",name);
        saySomething();
        return "welcome";
    }

    @RequestMapping(value="/react")
    public String Home(Model model){
        saySomething();
        return "index";
    }

    public void saySomething(){
        //System.out.println("Hi There");
    }

    public static String createEmailID(String firstPart,String secondPart){
        String generatedId = firstPart+"."+secondPart+"@testdomain.com";
        return generatedId;
    }
    public static boolean isValid(String email){
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(email);
        return m.matches();
    }
}
