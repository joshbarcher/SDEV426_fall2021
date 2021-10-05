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

    @RequestMapping("languages/random")
    public String random(Model model)
    {
        Language randLang = service.random();
        model.addAttribute("lang", randLang);

        return "random";
    }
}
