package edu.greenriver.sdev.myfirstspringproject.controllers;

import edu.greenriver.sdev.myfirstspringproject.model.Hike;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController is used with Web APIs (Web Services)
@RestController
public class HikingController
{
    private List<Hike> hikes = List.of(
        new Hike("Koko Crater Tramway", 3.0, 1, true),
        new Hike("Tiger mountain", 1.0, 3, false),
        new Hike("Green river college trails", 2.0, 3, true),
        new Hike("Snowlake", 15.0, 2, false),
        new Hike("Poo Poo Point", 13.0, 5, true),
        new Hike("Rattlesnake Ridge", 9.0, 5, false),
        new Hike("Ape Caves", 21.0, 2, false),
        new Hike("Ocean Shores", 1.5, 2, true),
        new Hike("Dash point State Park", 3.0, 3, true)
    );

    private List<String> locations = List.of("Koko Crater Tramway", "Tiger mountain", "Green river college trails",
            "Snowlake", "Poo Poo Point", "Rattlesnake Ridge", "Ape Caves", "Ocean Shores", "Dash point State Park");

    //each "route" in an MVC app begins at a method in a controller

    @RequestMapping("hikes") //http://localhost:8080/hikes
    public List<Hike> getAllHikes()
    {
        return hikes;
    }

    @RequestMapping("hikes/favorite") //http://localhost:8080/hikes/favorite
    public String getFavoriteHike()
    {
        return locations.get(4);
    }

    @RequestMapping("hikes/worst") //http://localhost:8080/hikes/favorite
    public String getWorstHike()
    {
        return locations.get(7);
    }

    @RequestMapping("hikes/longest") //http://localhost:8080/hikes/favorite
    public List<String> getLongHikes()
    {
        return null;
    }
}
