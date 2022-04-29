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
    private SettingService service;
    @GetMapping(value = "setting/list")
    public String list (Model model) {
        List<Setting> settings = service.findAll();
        model.addAttribute("settings", settings);
        return "setting/list";
    }
    @GetMapping("setting/update")
    public String show (@RequestParam("signature") String signature, ModelMap modelMap){
        Setting setting = service.findBySignature(signature);
        modelMap.addAttribute("settings", setting);
        modelMap.addAttribute("settings", new Setting());
        return "setting/update";
    }
    @PostMapping("setting/update")
    public String update (@ModelAttribute("setting") Setting setting, ModelMap model){
        service.update(setting);
        List<Setting> settings = service.findAll();
        model.addAttribute("settings", settings);
        return "setting/update";
    }

}
