package com.garage.garage_store.DTO;

import java.math.BigDecimal;

public record PartResponse (
        Integer id,
        String name,
        BigDecimal price,
        String model,
        Integer quantity
){

}
