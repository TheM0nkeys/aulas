package com.garage.garage_store.Controller;

import com.garage.garage_store.DTO.CarSaleRequest;
import com.garage.garage_store.DTO.CarSaleResponse;
import com.garage.garage_store.Model.Services.CarSaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas-carros")
public class CarSaleController {

    private final CarSaleService service;

    public CarSaleController(CarSaleService service) {
        this.service = service;
    }

    @PostMapping
    public CarSaleResponse save(@RequestBody CarSaleRequest dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<CarSaleResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CarSaleResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public CarSaleResponse update(
            @PathVariable Integer id,
            @RequestBody CarSaleRequest dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}