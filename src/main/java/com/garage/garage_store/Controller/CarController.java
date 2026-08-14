package com.garage.garage_store.Controller;

import com.garage.garage_store.Model.Services.CarService;
import com.garage.garage_store.DTO.CarRequest;
import com.garage.garage_store.DTO.CarResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarController {
    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping("/cadastro")
    public CarResponse save(@RequestBody CarRequest dto){
        return service.saveCar(dto);

    }
}
