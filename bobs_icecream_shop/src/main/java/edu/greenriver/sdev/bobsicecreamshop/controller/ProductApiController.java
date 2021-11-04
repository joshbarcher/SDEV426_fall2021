package edu.greenriver.sdev.bobsicecreamshop.controller;

import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import edu.greenriver.sdev.bobsicecreamshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products") //http://localhost:8080/products is our endpoint
public class ProductApiController
{
    private ProductService service;

    public ProductApiController(ProductService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Product> allProducts()
    {
        return service.allProducts();
    }

    @GetMapping("{id}") //http://localhost:8080/products/{id}
    public Product productById(int id)
    {
        return null;
    }

    @PostMapping
    public Product addProduct(Product product)
    {
        return null;
    }

    @PutMapping
    public Product editProduct(Product product)
    {
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteProduct(int id)
    {

    }
}












