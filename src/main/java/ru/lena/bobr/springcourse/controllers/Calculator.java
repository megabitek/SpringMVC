package ru.lena.bobr.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @RequestMapping("/calc")
    public String calculate(@RequestParam(value= "num_1", required = false) int num_1,
                            @RequestParam (value="num_2", required = false) int num_2,
                            @RequestParam (value="action", required = false) String action,
                            Model model){
    int rez = 0;
    switch (action){
    case "add": rez=num_1+num_2; break;
    case "mult": rez = num_1*num_2; break;
    case "sub": rez= num_1-num_2; break;
    case "div": {if (num_2!=0)  rez= num_1/num_2; else rez= 0; break;}
    }

        model.addAttribute("message",num_1+ " "+ action+ " "+ num_2+ " = "+ rez);
        return "calc";
    }
}
