package com.garage.garage_store.DTO;


import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public record CarRequest(
     String brand,
     String model,
     Integer year,
     String licensePlate,
     BigDecimal price
){

        }
