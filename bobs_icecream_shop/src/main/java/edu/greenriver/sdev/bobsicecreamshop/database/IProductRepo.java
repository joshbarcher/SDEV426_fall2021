package edu.greenriver.sdev.bobsicecreamshop.database;

import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepo extends CrudRepository<Product, String>
{
}
