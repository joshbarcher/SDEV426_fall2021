package edu.greenriver.sdev.programminglanguages.controllers;

import edu.greenriver.sdev.programminglanguages.model.Language;
import edu.greenriver.sdev.programminglanguages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

        return "single";
    }

    /*
        This matches routes like:
        localhost:9000/languages/rank/1
        localhost:9000/languages/rank/2
        localhost:9000/languages/rank/3
        localhost:9000/languages/rank/asdf
     */
    @RequestMapping("languages/rank/{rank}")
    public String byRank(Model model, @PathVariable int rank)
    {
        model.addAttribute("lang", service.languageByRank(rank));
        model.addAttribute("title", "A Language By Rank");
        model.addAttribute("header", "View a Language");

        return "single";
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
