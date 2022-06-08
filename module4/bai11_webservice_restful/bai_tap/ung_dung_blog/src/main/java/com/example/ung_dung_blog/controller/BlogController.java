package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.impl.BlogServiceImpl;
import com.example.ung_dung_blog.service.impl.CategoryService;

import java.util.List;
@Controller
public class BlogController {
    @Autowired
    private BlogServiceImpl blogService;
    @Autowired
    private CategoryService categoryService;

    public BlogController() {
    }

    @GetMapping("")
    public ModelAndView getBlogList(Model model) {
        List<Category> categories=categoryService.findAll();
        model.addAttribute("categories",categories);
        return new ModelAndView("index","blogs",blogService.findAll());
    }
}