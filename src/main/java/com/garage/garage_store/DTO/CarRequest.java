package com.garage.garage_store.DTO;

import java.math.BigDecimal;


public record CarRequest(
     String brand,
     String model,
     Integer year,
     String licensePlate,
     BigDecimal price
){

        }
