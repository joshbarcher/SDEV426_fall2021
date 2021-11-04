package edu.greenriver.sdev.bobsicecreamshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Sale> sale;
}











