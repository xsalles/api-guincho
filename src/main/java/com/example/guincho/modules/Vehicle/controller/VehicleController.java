package com.example.guincho.modules.Vehicle.controller;

import com.example.guincho.modules.Vehicle.model.VehicleModel;
import com.example.guincho.modules.Vehicle.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/create")
	public VehicleModel createVehicle(@Valid @RequestBody VehicleModel vehicleModel) {
		return vehicleService.cadastrarVeiculo(vehicleModel);
	}

	@PostMapping("/request-tow/{id}")
	public String requestTow(@PathVariable Integer id) {
		return vehicleService.solicitarGuincho(id);
	}

}
