package com.garage.garage_store.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;



@Entity
@Table(name = "cars")//aqui sera colocado o as informacoes do carros
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "price")
    private BigDecimal price;

}
