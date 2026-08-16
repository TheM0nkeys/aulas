package com.garage.garage_store.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CarSaleRequest(
        Integer carId,
        LocalDate saleDate,
        BigDecimal salePrice,
        String paymentMethod
) {
}