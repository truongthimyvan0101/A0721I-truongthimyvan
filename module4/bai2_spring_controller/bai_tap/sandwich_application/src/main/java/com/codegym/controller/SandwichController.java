package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String showSandwichCondiments(){
        return "index";
    }

    @PostMapping("/sandwich")
    public String showChoiceList(@RequestParam("data") String[] data, Model model){
        model.addAttribute("listChoice", data);
        return "result";
    }
}
