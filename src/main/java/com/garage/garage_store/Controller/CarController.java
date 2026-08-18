package com.garage.garage_store.Controller;

import com.garage.garage_store.Model.Services.CarService;
import com.garage.garage_store.DTO.CarRequest;
import com.garage.garage_store.DTO.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService service;


    @GetMapping("/get")
    public List<CarResponse> findAll(
            @RequestParam(required = false) String marca
    ) {
        return service.findAll(marca);
    }

    @GetMapping("/get/{id}")
    public CarResponse findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse save(@RequestBody CarRequest dto) {
        return service.saveCar(dto);
    }

    @PutMapping("/save/{id}")
    public CarResponse update(
            @PathVariable Integer id,
            @RequestBody CarRequest dto
    ) {
        return service.updateCar(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deleteCar(id);
    }
}