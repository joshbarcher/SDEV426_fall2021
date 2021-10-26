package edu.greenriver.sdev.bobsicecreamshop.database;

import edu.greenriver.sdev.bobsicecreamshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepo extends JpaRepository<Product, Integer>
{
}
