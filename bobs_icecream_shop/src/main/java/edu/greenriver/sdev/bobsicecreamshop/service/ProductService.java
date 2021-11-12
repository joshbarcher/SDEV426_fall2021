package edu.greenriver.sdev.bobsicecreamshop.service;

import edu.greenriver.sdev.bobsicecreamshop.database.IProductRepo;
import edu.greenriver.sdev.bobsicecreamshop.database.ISaleRepo;
import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService
{
    private IProductRepo productRepo;
    private ISaleRepo saleRepo;

    public ProductService(IProductRepo productRepo, ISaleRepo saleRepo)
    {
        this.productRepo = productRepo;
        this.saleRepo = saleRepo;
    }

    public List<Product> allProducts()
    {
        return productRepo.findAll();
    }

    public boolean productExists(int id)
    {
        return productById(id) != null;
    }

    public Product productById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }

    public Product saveProduct(Product product)
    {
        return productRepo.save(product);
    }

    public Product editProduct(Product product)
    {
        if (productRepo.findById(product.getProductId()).isEmpty())
        {
            throw new NoSuchElementException("Missing product");
        }
        return productRepo.save(product);
    }

    public void deleteProduct(int id)
    {
        if (productRepo.findById(id).isEmpty())
        {
            throw new NoSuchElementException("Missing product");
        }
        productRepo.deleteById(id);
    }
}














