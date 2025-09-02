package com.example.guincho.modules.Vehicle.repository;

import com.example.guincho.modules.Vehicle.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleModel, Integer> {
}
