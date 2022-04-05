package com.codegym.case_study_java_web.controller;

import com.codegym.case_study_java_web.model.RentType;
import com.codegym.case_study_java_web.model.Service;
import com.codegym.case_study_java_web.model.ServiceType;
import com.codegym.case_study_java_web.service.RentTypeService;
import com.codegym.case_study_java_web.service.ServiceService;
import com.codegym.case_study_java_web.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ServiceController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceService serviceService;
    @GetMapping("/service")
    public ModelAndView listServices(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Service> services;
        if (search.isPresent()) {
            services = serviceService.findAllByNameContaining(search.get(), pageable);
        } else {
            services = serviceService.findAll(pageable);
        }
        return new ModelAndView("service/list","services",services);
    }
    @GetMapping("/create")
    public ModelAndView getCreatePage(Model model){
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("service", new Service());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveService(@ModelAttribute("service") Service service) {
        serviceService.save(service);
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("service", new Service());
        modelAndView.addObject("message", "Created service successfully");
        return modelAndView;
    }
}
