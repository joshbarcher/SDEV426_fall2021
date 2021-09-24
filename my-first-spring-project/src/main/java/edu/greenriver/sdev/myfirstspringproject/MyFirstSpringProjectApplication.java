package edu.greenriver.sdev.myfirstspringproject;

import edu.greenriver.sdev.myfirstspringproject.model.Hike;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstSpringProjectApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MyFirstSpringProjectApplication.class, args);

        //show you what Lombok is doing!
        Hike hike = new Hike("Green Canyon", 4, 2, true);
        System.out.println("Hike is " + hike.getMiles() + " miles long");
        System.out.println(hike);

        Hike secondHike = new Hike("Green Canyon", 4, 2, true);
        System.out.println("Equal? " + hike.equals(secondHike));

        //try to instantiate a Hike object using the Lombok-generated builder
        Hike thirdHike = Hike.builder()
            .difficulty(3)
            .favorited(false)
            .location("Puyallup Trail")
            .build();
        System.out.println(thirdHike);
    }
}
