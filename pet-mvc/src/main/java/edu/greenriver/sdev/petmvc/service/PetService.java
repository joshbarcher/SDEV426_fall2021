package edu.greenriver.sdev.petmvc.service;

import edu.greenriver.sdev.petmvc.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//mark our service as a Spring bean, this service
//is responsible for all business logic
//(accessing pets, validating pets, creating pets, ...)
@Service
public class PetService
{
    //fudge a bit with our data layer
    private List<Pet> petsData = List.of(
        Pet.builder().name("Lazarus").nickname("Lazzy").type("Cat").build(),
        Pet.builder().name("Ginny").nickname("Ginny").type("Cat").build(),
        Pet.builder().name("Fuzzbucket").nickname("Fuzz").type("Dog").build(),
        Pet.builder().name("Bob").nickname("Bobby").type("Bird").build()
    );

    public PetService()
    {
        System.out.println("Spring container created the PetService");
    }

    public List<Pet> getAllPets()
    {
        //return the read-only pet list
        return petsData;
    }

    public List<Pet> getCats()
    {
        return petsData
            .stream()
            .filter(pet -> pet.getType().equals("Cat"))
            .collect(Collectors.toList());
    }

    public List<Pet> getDogs()
    {
        return petsData
            .stream()
            .filter(pet -> pet.getType().equals("Dog"))
            .collect(Collectors.toList());
    }
}
