package com.garage.garage_store.Model.Services;

import com.garage.garage_store.Model.Entity.Car;
import com.garage.garage_store.Model.Repository.CarRepository;
import com.garage.garage_store.DTO.CarRequest;
import com.garage.garage_store.DTO.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }
    //colocar si necesita retorno o no
    public CarResponse saveCar(CarRequest dto){
        Car car = Car.builder()
                .brand(dto.brand())
                .model(dto.model())
                .year(dto.year())
                .licensePlate(dto.licensePlate())
                .price(dto.price())
                .build();

        repository.save(car);

        return new CarResponse(
                car.getBrand()
        );
    }
}
