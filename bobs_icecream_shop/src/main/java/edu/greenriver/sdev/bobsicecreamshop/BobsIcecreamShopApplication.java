package edu.greenriver.sdev.bobsicecreamshop;

import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BobsIcecreamShopApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(BobsIcecreamShopApplication.class, args);

        Product product = new Product();

        //then use the product as if it's an entity
    }

}
