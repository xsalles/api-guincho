package com.example.guincho.modules.Vehicle.services;

import com.example.guincho.modules.Vehicle.model.VehicleModel;
import com.example.guincho.modules.Vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	public ResponseEntity<?> getAll() {
		if (vehicleRepository.findAll().isEmpty()) {
			return new ResponseEntity<>("No content: No vehicles registered", HttpStatus.NO_CONTENT);
		}

		return ResponseEntity.ok().body(vehicleRepository.findAll());
	}

	public ResponseEntity<?> getById(Integer id) {
		if (!vehicleRepository.existsById(id)) {
			return new ResponseEntity<>("Error: Vehicle not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(vehicleRepository.findById(id), HttpStatus.OK);
	}

	public ResponseEntity<String> registerVehicle(VehicleModel vehicleModel) {
		if (vehicleModel == null) {
			return new ResponseEntity<>("Please, provide vehicle data", HttpStatus.BAD_REQUEST);
		}

		vehicleRepository.save(vehicleModel);

		return new ResponseEntity<>("Vehicle registered successfully", HttpStatus.CREATED);
	}

	public ResponseEntity<String> requestTow(Integer id) {
		if (!vehicleRepository.existsById(id)) {
			return new ResponseEntity<>("Error: Vehicle not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("Tow truck requested successfully", HttpStatus.OK);
	}

	public ResponseEntity<String> deleteById(Integer id) {
		if (!vehicleRepository.existsById(id)) {
			return new ResponseEntity<>("Error: Vehicle not found", HttpStatus.NOT_FOUND);
		}

		vehicleRepository.deleteById(id);

		return new ResponseEntity<>("Vehicle deleted sucessfully", HttpStatus.OK);
	}
}
