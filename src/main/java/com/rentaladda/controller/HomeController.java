package com.rentaladda.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
@Controller
public class HomeController {

private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value="/home")
    public String Welcome(){
        //model.addAttribute("name",name);
        //Was testing AOP here
        saySomething();
        return "welcome";
    }

    @RequestMapping(value="/react")
    public String Home(Model model){
        saySomething();
        return "index";
    }

    //Was testing AOP here
    public void saySomething(){
        //System.out.println("Hi There");
        List<String> ll = new ArrayList<String>();
        ll.add("names");
        ll.add("surnames");

        Stream<String> output = ll.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
               return s == "nam" ? false : true;
            }
        });

        Stream.of("abc","aeg").sorted().findFirst().ifPresent(System.out::println);

        System.out.println(output.count());
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
