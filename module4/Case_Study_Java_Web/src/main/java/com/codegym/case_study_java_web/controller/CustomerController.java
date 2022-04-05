package com.codegym.case_study_java_web.controller;

import com.codegym.case_study_java_web.model.Customer;
import com.codegym.case_study_java_web.model.CustomerType;
import com.codegym.case_study_java_web.service.CustomerService;
import com.codegym.case_study_java_web.service.CustomerTypeService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    public CustomerTypeService customerTypeService;
//    @GetMapping("")
//    public ModelAndView getCustomerList(@RequestParam(name = "nameCus", required = false,defaultValue = "") String name, @PageableDefault(size = 2) @SortDefault(value = "name", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<Customer> customers = customerService.searchByName(name, pageable);
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("customers", customers);
//        modelAndView.addObject("nameCus", name);
//        return modelAndView;
//    };
//@GetMapping("customer")
//public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable) {
//    Page<Customer> customers;
//    if (search.isPresent()) {
//        customers = customerService.findAllByNameContaining(search.get(), pageable);
//    } else {
//        customers = customerService.findAll(pageable);
//    }
//    ModelAndView modelAndView = new ModelAndView("customer/list");
//    modelAndView.addObject("customers", customers);
//    return modelAndView;
//}
    @GetMapping("/home")
    public String home() {
        return "home";
    }
//    @GetMapping("/customer")
//    public ModelAndView getCustomerList(@PageableDefault(size = 5) Pageable pageable) {
//    return new ModelAndView("customer/list", "customers", customerService.findAll(pageable));
//    }
    @GetMapping("/customer")
    public ModelAndView listCustomers(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        return new ModelAndView("customer/list","customers",customers);
    }

//    @GetMapping("/create")
//    public ModelAndView getCreatePage(Model model){
//        List<CustomerType> customerTypes = customerTypeService.findAll();
//        model.addAttribute("customerTypes", customerTypes);
//        return new ModelAndView("customer/create", "customer", new Customer());
//    }
//
//    @PostMapping("/create")
//    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
//        customerService.saveCustomer(customer);
//        redirectAttributes.addFlashAttribute("message", "Create success");
//        return "redirect:/";
//
//    }
@GetMapping("/create-customer")
public ModelAndView getCreatePage(Model model){
    List<CustomerType> customerTypes = customerTypeService.findAll();
    model.addAttribute("customerTypes", customerTypes);
    ModelAndView modelAndView = new ModelAndView("customer/create");
    modelAndView.addObject("customer", new Customer());
    return modelAndView;
}

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "Created customer successfully");
        return modelAndView;
    }



}
