package edu.greenriver.sdev.bobsicecreamshop.database;

import edu.greenriver.sdev.bobsicecreamshop.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepo extends JpaRepository<Sale, Integer>
{
}
