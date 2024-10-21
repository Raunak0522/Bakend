package com.lcwd.mvc.springmvcproject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SuperMan {
// Request mapping is used to map the url with method
    @RequestMapping("/about")
    public String aboutRequestHandler(){
            System.out.println("Processing about request");
            return "about";
    }
}
