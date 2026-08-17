package com.garage.garage_store.Model.Services;

import com.garage.garage_store.Model.Entity.Car;
import com.garage.garage_store.Model.Repository.CarRepository;
import com.garage.garage_store.DTO.CarRequest;
import com.garage.garage_store.DTO.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public CarResponse saveCar(CarRequest dto) {

        if (dto.licensePlate() != null
                && repository.existsByLicensePlate(dto.licensePlate())) {
            throw new RuntimeException("Já existe um carro com essa placa");
        }

        Car car = Car.builder()
                .brand(dto.brand())
                .model(dto.model())
                .year(dto.year())
                .licensePlate(dto.licensePlate())
                .price(dto.price())
                .build();

        Car savedCar = repository.save(car);

        return toResponse(savedCar);
    }

    public List<CarResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(car -> new CarResponse(
                        car.getId(),
                        car.getBrand(),
                        car.getModel(),
                        car.getYear(),
                        car.getLicensePlate(),
                        car.getPrice()
                ))
                .toList();
    }

    public CarResponse findById(Integer id) {

        Car car = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Carro não encontrado")
                );

        return new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getPrice()
        );
    }

    public CarResponse updateCar(Integer id, CarRequest dto) {

        Car car = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        // Impede colocar em um carro a placa que já pertence a outro carro.
        if (dto.licensePlate() != null
                && repository.existsByLicensePlateAndIdNot(dto.licensePlate(), id)) {
            throw new RuntimeException("Já existe outro carro com essa placa");
        }

        // Só altera o campo se ele vier no JSON.
        // Assim você pode editar somente brand, somente price, etc.
        if (dto.brand() != null) {
            car.setBrand(dto.brand());
        }

        if (dto.model() != null) {
            car.setModel(dto.model());
        }

        if (dto.year() != null) {
            car.setYear(dto.year());
        }

        if (dto.licensePlate() != null) {
            car.setLicensePlate(dto.licensePlate());
        }

        if (dto.price() != null) {
            car.setPrice(dto.price());
        }

        Car updatedCar = repository.save(car);

        return toResponse(updatedCar);
    }

    public void deleteCar(Integer id) {

        Car car = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Carro não encontrado")
                );

        repository.delete(car);
    }


    private CarResponse toResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getPrice()
        );
    }
}
