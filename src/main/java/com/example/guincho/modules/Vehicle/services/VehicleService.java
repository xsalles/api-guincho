package com.example.guincho.modules.Vehicle.services;

import com.example.guincho.modules.Vehicle.model.VehicleModel;
import com.example.guincho.modules.Vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	private VehicleModel vehicleModel;


	public VehicleModel cadastrarVeiculo(VehicleModel vehicleModel) {

		if (vehicleModel == null) {
			throw new IllegalArgumentException("Please, complete all fields");
		}

		return vehicleRepository.save(vehicleModel);
	}

	public String solicitarGuincho(Integer id) {
		VehicleModel vehicle = vehicleRepository.getById(id);

		if (vehicle == null) {
			return "Vehicle não encontrado";
		}

		return "Guincho solicitado para o veículo com placa: " + vehicle.getPlacaVeiculo() + " do cliente: " + vehicle.getNomeCliente() + ", telefone: " + vehicle.getTelefoneCelular() + ", endereço: " + vehicle.getEndereco() + ", cidade: " + vehicle.getCidade();
	}
}
