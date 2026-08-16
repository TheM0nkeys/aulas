package com.garage.garage_store.Model.Services;

import com.garage.garage_store.DTO.CarSaleRequest;
import com.garage.garage_store.DTO.CarSaleResponse;
import com.garage.garage_store.Model.Entity.Car;
import com.garage.garage_store.Model.Entity.CarSale;
import com.garage.garage_store.Model.Repository.CarRepository;
import com.garage.garage_store.Model.Repository.CarSaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarSaleService {

    private final CarSaleRepository saleRepository;
    private final CarRepository carRepository;

    public CarSaleService(
            CarSaleRepository saleRepository,
            CarRepository carRepository
    ) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
    }

    public CarSaleResponse save(CarSaleRequest dto) {

        Car car = carRepository.findById(dto.carId())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        CarSale sale = CarSale.builder()
                .car(car)
                .saleDate(dto.saleDate())
                .salePrice(dto.salePrice())
                .paymentMethod(dto.paymentMethod())
                .build();

        saleRepository.save(sale);

        return toResponse(sale);
    }

    public List<CarSaleResponse> findAll() {

        return saleRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CarSaleResponse findById(Integer id) {

        CarSale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        return toResponse(sale);
    }

    public CarSaleResponse update(Integer id, CarSaleRequest dto) {

        CarSale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        Car car = carRepository.findById(dto.carId())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        sale.setCar(car);
        sale.setSaleDate(dto.saleDate());
        sale.setSalePrice(dto.salePrice());
        sale.setPaymentMethod(dto.paymentMethod());

        saleRepository.save(sale);

        return toResponse(sale);
    }

    public void delete(Integer id) {

        CarSale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        saleRepository.delete(sale);
    }

    private CarSaleResponse toResponse(CarSale sale) {

        return new CarSaleResponse(
                sale.getId(),
                sale.getCar().getId(),
                sale.getCar().getBrand(),
                sale.getCar().getModel(),
                sale.getSaleDate(),
                sale.getSalePrice(),
                sale.getPaymentMethod()
        );
    }
}
