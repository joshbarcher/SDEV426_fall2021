package edu.greenriver.sdev.petmvc.controllers;

import edu.greenriver.sdev.petmvc.model.Pet;
import edu.greenriver.sdev.petmvc.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PetController
{
    //let spring inject the following dependency
    private PetService service;

    public PetController(PetService service)
    {
        this.service = service;
        System.out.println("Spring container created the PetController");
    }

    @RequestMapping("pets/all")
    public String getAllPetsPage(Model model)
    {
        //reminder, the Model holds variables for view templates
        List<Pet> pets = service.getAllPets();
        model.addAttribute("pets", pets);

        //return the name of the template
        return "all-pets";
    }
}

