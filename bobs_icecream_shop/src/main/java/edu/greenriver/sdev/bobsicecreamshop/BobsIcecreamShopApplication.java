package edu.greenriver.sdev.bobsicecreamshop;

import edu.greenriver.sdev.bobsicecreamshop.database.IProductRepo;
import edu.greenriver.sdev.bobsicecreamshop.database.ISaleRepo;
import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import edu.greenriver.sdev.bobsicecreamshop.model.Sale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class BobsIcecreamShopApplication
{

    public static void main(String[] args)
    {
        //access the context and data layer
        ApplicationContext ctx = SpringApplication.run(BobsIcecreamShopApplication.class, args);
        IProductRepo productRepo = ctx.getBean(IProductRepo.class);
        ISaleRepo saleRepo = ctx.getBean(ISaleRepo.class);

        //create a few entities
        Product neopolitan = Product.builder()
            .name("neopolitan")
            .price(4.99)
            .category("ice cream")
            .expires(LocalDate.now())
            .details("Yummy!")
            .build();

        Product pralines = Product.builder()
            .name("pralines and cream")
            .price(6.99)
            .category("ice cream")
            .expires(LocalDate.now())
            .details("Also, Yummy!")
            .build();

        Sale iceCreamSale = Sale.builder()
            .newPrice(3.99)
            .startingDate(LocalDate.now())
            .daysOfSale(2)
            .build();

        //save them
        productRepo.save(pralines);
        saleRepo.save(iceCreamSale);
        productRepo.save(neopolitan);

        //connect both sides of the relationship
        neopolitan.setSale(iceCreamSale);
        iceCreamSale.setProduct(neopolitan);

        //save the product and sale after connecting them
        productRepo.save(neopolitan);
        saleRepo.save(iceCreamSale);

        Product fromDb = productRepo.findById(2).orElse(null);
        System.out.println(fromDb);
    }
}
