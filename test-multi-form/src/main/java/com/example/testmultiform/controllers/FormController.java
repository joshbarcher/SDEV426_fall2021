package com.example.testmultiform.controllers;

import com.example.testmultiform.model.FormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController
{
    @GetMapping("step1")
    public String one(Model model)
    {
        model.addAttribute("data", new FormData());
        return "one";
    }

    @PostMapping("step2")
    public String two(Model model, @ModelAttribute FormData data)
    {
        model.addAttribute("data", data);
        return "two";
    }

    @PostMapping("step3")
    public String three(Model model, @ModelAttribute FormData data)
    {
        model.addAttribute("data", data);
        return "three";
    }

    @PostMapping("save")
    public String save(Model model, @ModelAttribute FormData data)
    {
        model.addAttribute("data", data);
        return "saved";
    }
}
