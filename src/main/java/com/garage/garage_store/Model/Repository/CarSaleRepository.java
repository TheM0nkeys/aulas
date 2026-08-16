package com.garage.garage_store.Model.Repository;

import com.garage.garage_store.Model.Entity.CarSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarSaleRepository extends JpaRepository<CarSale, Integer> {
}