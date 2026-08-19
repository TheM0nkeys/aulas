package com.garage.garage_store.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "part_sale")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name ="sale_date", nullable = false)
    private LocalDate sale_date;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;
}
