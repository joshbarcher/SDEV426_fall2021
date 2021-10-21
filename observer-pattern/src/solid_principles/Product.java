package solid_principles;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
/*
    How many responsibilities does this class have?
 */
public class Product
{
    private int id;
    private String name;
    private double price;
    private String description;
    private LocalDate catalogReleased;
    private String catalog;
    private int pageInCatalog;
    private List<Order> orders;
    private Comparator<Order> orderSorter;
    private boolean onSale;

    //more methods here...

    public Product(int id, String name, double price,
                   String description, String catalog,
                   int pageInCatalog, List<Order> orders, boolean onSale)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.catalog = catalog;
        this.pageInCatalog = pageInCatalog;
        this.orders = orders;
        this.onSale = onSale;
    }

    public void updateCatalogPage(String catalog, int page)
    {
        //...
    }

    public void placeOrder()
    {

    }
}
