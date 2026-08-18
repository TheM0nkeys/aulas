package com.garage.garage_store.Model.Repository;

import com.garage.garage_store.Model.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsByLicensePlate(String licensePlate);

    boolean existsByLicensePlateAndIdNot(
            String licensePlate,
            Integer id);
            List<Car> findByBrand(String brand);
}
