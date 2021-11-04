package edu.greenriver.sdev.bobsicecreamshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="sale")
public class Sale implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;

    private double newPrice;
    private LocalDate startingDate;
    private int daysOfSale;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="productId")
    @JsonIgnore
    private Product product;
}














