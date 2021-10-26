package edu.greenriver.sdev.bobsicecreamshop.model;

import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String name;
    private double price;

    @Column(name="type")
    private String category;
    @Column(name="expires_on")
    private LocalDate expires;

    private String details; //other attributes of the product

    //one-to-one
    @ToString.Exclude
    @OneToOne(mappedBy = "product", fetch = FetchType.EAGER)
    private Sale sale;
}











