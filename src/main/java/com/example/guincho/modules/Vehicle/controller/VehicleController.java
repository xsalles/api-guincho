package com.example.guincho.modules.Vehicle.controller;

import com.example.guincho.modules.Vehicle.model.VehicleModel;
import com.example.guincho.modules.Vehicle.services.VehicleService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/create")
	public ResponseEntity<String> createVehicle(@Valid @RequestBody VehicleModel vehicleModel) {
		return vehicleService.registerVehicle(vehicleModel);
	}

	@PostMapping("/request-tow/{id}")
	public ResponseEntity<String> requestTow(@PathVariable Integer id) {
		return vehicleService.requestTow(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteVehicleById(@PathVariable Integer id) {
		return vehicleService.deleteById(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getVehicleById(@PathVariable Integer id) {
		return vehicleService.getById(id);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllVehicles() {
		return vehicleService.getAll();
	}

}
