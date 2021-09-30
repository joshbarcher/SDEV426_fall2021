package edu.greenriver.sdev.petmvc;

import edu.greenriver.sdev.petmvc.controllers.PetController;
import edu.greenriver.sdev.petmvc.service.PetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetMvcApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(PetMvcApplication.class, args);
    }
}
