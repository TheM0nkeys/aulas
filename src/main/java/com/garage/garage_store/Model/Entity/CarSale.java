package com.garage.garage_store.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "car_sales")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "sale_date", nullable = false)
    private LocalDate saleDate;

    @Column(name = "sale_price", nullable = false)
    private BigDecimal salePrice;

    @Column(name = "payment_method")
    private String paymentMethod;
}