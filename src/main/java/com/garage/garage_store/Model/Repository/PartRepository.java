package com.garage.garage_store.Model.Repository;

import com.garage.garage_store.Model.Entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Integer> {
    boolean existsByModel(String model);

    boolean existsByNameAndIdNot(String name, Integer id);
}
