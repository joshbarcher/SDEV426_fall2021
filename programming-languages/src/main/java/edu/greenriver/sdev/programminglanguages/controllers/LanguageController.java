package edu.greenriver.sdev.programminglanguages.controllers;

import edu.greenriver.sdev.programminglanguages.model.Language;
import edu.greenriver.sdev.programminglanguages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LanguageController
{
    //access the service layer using dependency injection
    private LanguageService service;

    public LanguageController(LanguageService service)
    {
        this.service = service;
    }

    //we can save view-template variables to the Model object
    //so we can use them in our pages
    @RequestMapping("languages/random")
    public String random(Model model)
    {
        Language randLang = service.random();
        model.addAttribute("lang", randLang);
        model.addAttribute("title", "A Random Language");
        model.addAttribute("header", "View a Random Language");

        return "random";
    }

    @RequestMapping("languages/all")
    public String all(Model model)
    {
        //store all languages to the model
        model.addAttribute("langs", service.allLanguages());
        return "all";
    }

    @RequestMapping("languages/top3")
    public String top(Model model)
    {
        model.addAttribute("langs", service.topThree());
        return "all";
    }
}
