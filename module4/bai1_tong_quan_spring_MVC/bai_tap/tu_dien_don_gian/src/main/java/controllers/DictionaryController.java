package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.EnglishService;
import service.EnglishServiceilmp;

@Controller
public class DictionaryController {
    private EnglishService englishService = new EnglishServiceilmp();
    @GetMapping("/")
    public String getDictionary() {
        return "index";
    }
    @PostMapping(path = "/")
    public ModelAndView translate(@RequestParam String word, Model model) {
        String wordVN = this.englishService.findByEnglish(word);
        if (wordVN ==null) {
            return new ModelAndView("error-404");
        } else {
            model.addAttribute ("word", word);
            return new ModelAndView("view", "wordVN", wordVN);
        }
    }
}
