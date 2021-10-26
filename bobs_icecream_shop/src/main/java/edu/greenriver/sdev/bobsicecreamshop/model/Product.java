package edu.greenriver.sdev.bobsicecreamshop.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="items")
public class Product
{
    @Id
    private String name;
    private double price;

    @Column(name="type")
    private String category;
    @Column(name="expires_on")
    private LocalDate expires;

    private String details; //other attributes of the product
}
