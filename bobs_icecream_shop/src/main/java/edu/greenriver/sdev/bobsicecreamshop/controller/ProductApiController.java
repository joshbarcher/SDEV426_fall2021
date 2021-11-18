package edu.greenriver.sdev.bobsicecreamshop.controller;

import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import edu.greenriver.sdev.bobsicecreamshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products") //http://localhost:8080/products is our endpoint
@CrossOrigin(origins="*")
public class ProductApiController
{
    private ProductService service;

    public ProductApiController(ProductService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> allProducts()
    {
        return new ResponseEntity<>(service.allProducts(), HttpStatus.OK);
    }

    @GetMapping("{id}") //http://localhost:8080/products/{id}
    public ResponseEntity<Product> productById(@PathVariable int id)
    {
        if (!service.productExists(id))
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.productById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>(service.saveProduct(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> editProduct(@RequestBody Product product)
    {
        if (!service.productExists(product.getProductId()))
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.editProduct(product), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable int id)
    {
        service.deleteProduct(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}












