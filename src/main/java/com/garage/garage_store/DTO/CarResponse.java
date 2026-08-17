package com.garage.garage_store.DTO;

import java.math.BigDecimal;

public record CarResponse(
        Integer id,
        String brand,
        String model,
        Integer year,
        String licensePlate,
        BigDecimal price
) {
}
