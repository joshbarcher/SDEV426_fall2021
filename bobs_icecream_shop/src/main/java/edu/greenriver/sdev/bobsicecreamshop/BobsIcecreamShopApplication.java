package edu.greenriver.sdev.bobsicecreamshop;

import edu.greenriver.sdev.bobsicecreamshop.database.IProductRepo;
import edu.greenriver.sdev.bobsicecreamshop.database.ISaleRepo;
import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import edu.greenriver.sdev.bobsicecreamshop.model.Sale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        Product bananaSplit = Product.builder()
                .name("banana split")
                .price(12.99)
                .category("ice cream")
                .expires(LocalDate.now())
                .details("Contains bananas")
                .build();

        Product doubleScoop = Product.builder()
                .name("double scoop of icecream")
                .price(4.49)
                .category("ice cream")
                .expires(LocalDate.now())
                .details("Careful carrying this around!")
                .build();

        Sale iceCreamSale = Sale.builder()
            .newPrice(3.99)
            .startingDate(LocalDate.now())
            .daysOfSale(2)
            .build();

        Sale halloweenSale = Sale.builder()
                .newPrice(4.49)
                .startingDate(LocalDate.now())
                .daysOfSale(1)
                .build();

        Sale christmasSale = Sale.builder()
                .newPrice(2.99)
                .startingDate(LocalDate.now())
                .daysOfSale(5)
                .build();

        //save them
        productRepo.save(pralines);
        productRepo.save(neopolitan);
        productRepo.save(bananaSplit);
        productRepo.save(doubleScoop);
        saleRepo.save(iceCreamSale);

        //connect both sides of the relationship
        neopolitan.setSale(new ArrayList<>());
        List<Sale> sales = neopolitan.getSale();
        sales.add(iceCreamSale);
        sales.add(halloweenSale);
        sales.add(christmasSale);
        iceCreamSale.setProduct(neopolitan);
        halloweenSale.setProduct(neopolitan);
        christmasSale.setProduct(neopolitan);

        //save the product and sale after connecting them
        productRepo.save(neopolitan);
        saleRepo.save(iceCreamSale);
        saleRepo.save(halloweenSale);
        saleRepo.save(christmasSale);

        Product fromDb = productRepo.findById(2).orElse(null);
        for (Sale sale : fromDb.getSale())
        {
            System.out.println(sale);
        }

        Iterator<Sale> it = fromDb.getSale().iterator();
        while (it.hasNext())
        {
            Sale sale = it.next();
            System.out.println(sale);
        }
    }
}
