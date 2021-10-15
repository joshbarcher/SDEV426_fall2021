package edu.greenriver.sdev.programminglanguages.controllers;

import edu.greenriver.sdev.programminglanguages.model.Language;
import edu.greenriver.sdev.programminglanguages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
    The primary controller of the web site.

    @author Josh Archer
    @version 1.0
*/
@Controller
@RequestMapping("languages")
public class LanguageController
{
    //access the service layer using dependency injection
    private LanguageService service;

    /**
     * Creates a new controller with the service
     * injected into the controller.
     * @param service the language service
     */
    public LanguageController(LanguageService service)
    {
        this.service = service;
    }

    //we can save view-template variables to the Model object
    //so we can use them in our pages
    @RequestMapping("random")
    public String random(Model model)
    {
        Language randLang = service.random();
        model.addAttribute("lang", randLang);
        model.addAttribute("title", "A Random Language");
        model.addAttribute("header", "View a Random Language");

        return "pages/single";
    }

    /*
        This matches routes like:
        localhost:9000/languages/rank/1
        localhost:9000/languages/rank/2
        localhost:9000/languages/rank/3
        localhost:9000/languages/rank/asdf
     */
    @RequestMapping("rank/{rank}")
    public String byRank(Model model, @PathVariable int rank)
    {
        model.addAttribute("lang", service.languageByRank(rank));
        model.addAttribute("title", "A Language By Rank");
        model.addAttribute("header", "View a Language");

        return "pages/single";
    }

    @RequestMapping("all")
    public String all(Model model)
    {
        //store all languages to the model
        model.addAttribute("langs", service.allLanguages());
        return "pages/all";
    }

    @RequestMapping("top3")
    public String top(Model model)
    {
        model.addAttribute("langs", service.topThree());
        return "pages/all";
    }

    @RequestMapping("id/{id}")
    public String byId(Model model, @PathVariable int id)
    {
        model.addAttribute("lang", service.languageById(id));
        model.addAttribute("title", "A Language By Id");
        model.addAttribute("header", "View a Language");
        return "pages/single";
    }

    @RequestMapping("anotherrandom")
    public String anotherRandom(Model model)
    {
        Language randLang = service.random();
        model.addAttribute("lang", randLang);
        model.addAttribute("title", "A Random Language");
        model.addAttribute("header", "View a Random Language");

        return "pages/single";
    }

    @GetMapping("add/form")
    public String loadForm(Model model)
    {
        //pass an empty object to a form
        Language lang = new Language(0, "Ruby", 0, false);
        model.addAttribute("lang", lang);
        return "pages/add-language";
    }

    @PostMapping("add/form")
    public String handleForm(@ModelAttribute Language lang)
    {
        System.out.println("Posted from form: " + lang);
        service.saveLanguage(lang);
        return "redirect:/languages/all";
    }
}


















