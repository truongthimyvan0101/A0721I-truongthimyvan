package com.codegym.controller;
import com.codegym.model.Setting;
import com.codegym.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private SettingService settingService;
    @GetMapping("/")
    public String showListForm(Model model){
        List<Setting> settings = settingService.getAllUser();
        model.addAttribute("settingList", settings);
        return "list";
    }

    @GetMapping("/list")
    public String showCreateForm(Model model) {
        String[] languages ={"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pages = {5, 10, 15, 20, 25};
        model.addAttribute("setting", new Setting());
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        return "/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("setting") Setting setting) {
        settingService.update(setting);
        return "redirect:/";
    }










}
