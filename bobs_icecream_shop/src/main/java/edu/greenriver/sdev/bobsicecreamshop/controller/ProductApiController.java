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
    public Product productById(@PathVariable int id)
    {
        return service.productById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product)
    {
        return service.saveProduct(product);
    }

    @PutMapping
    public Product editProduct(Product product)
    {
        return service.editProduct(product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(int id)
    {
        service.deleteProduct(id);
    }
}












