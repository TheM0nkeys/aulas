package com.garage.garage_store.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CarSaleResponse(
        Integer id,
        Integer carId,
        String brand,
        String model,
        LocalDate saleDate,
        BigDecimal salePrice,
        String paymentMethod
) {
}