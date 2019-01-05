package com.rentaladda.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *  This is the default controller to access most features on the home page navigation bar
 */
@Component
@Controller
class HomeController {

private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value="/home")
    public String Welcome(Model model){
        model.addAttribute("isEnabledSignUp",true);
        model.addAttribute("isEnabledLogin",true);
        model.addAttribute("isLoggedIn",false);
        //Was testing AOP here
        return "welcome";
    }

    @RequestMapping(value="/LoginPopup")
    public String LoginPopup(Model model){
        model.addAttribute("isEnabledSignUp",true);
        model.addAttribute("isEnabledLogin",true);
        model.addAttribute("isLoggedIn",false);
        //Was testing AOP here
        return "LoginPopup";
    }

    //Was testing AOP here
/*    public void saySomething(){
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
    }*/

    public static boolean isValid(String email){
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(email);
        return m.matches();
    }

    private class innerController{

        {
            System.out.println("private inner class");
        }

        @RequestMapping(value = "/innerHome")
        public void innerHome(){
            System.out.println("Inner home print");
        }

        public String test() {
            return null;
        }
    }
}
