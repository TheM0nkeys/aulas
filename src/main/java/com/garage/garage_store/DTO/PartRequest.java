package com.garage.garage_store.DTO;

import java.math.BigDecimal;

public record PartRequest(
        Integer id,
        Integer partId,
        String name,
        BigDecimal price,
        String model,
        Integer quantity
) {
}
