package com.garage.garage_store.Model.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sale")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "quantitiy", nullable = false)
    private Integer quantity;

    @Column (name = "price", nullable = false)
    private BigDecimal price;
}
