package com.example.guincho.modules.Vehicle.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity( name = "veiculos" )
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank( message = "Please, complete the plate field" )
    @Pattern( regexp = "^[A-Z]{3}-[0-9]{4}$", message = "Invalid plate format")
    @Column( name = "placa_veiculo", unique = true )
    private String placaVeiculo;

    @NotBlank( message = "Please, complete the name field" )
    @Pattern( regexp = "^[A-Za-zÀ-ÿ ]+$", message = "The name should contain only letters" )
    @Column( name = "nome_cliente" )
    private String nomeCliente;

    @NotBlank( message = "Please, complete the phone number field" )
    @Pattern( regexp = "[0-9]{11}", message = "The phone number should contain only numbers and have 11 digits" )
    @Column( name = "telefone_celular" )
    private String telefoneCelular;

    @NotBlank( message = "Please, complete the address field" )
    private String endereco;

    @NotBlank( message = "Please, complete the city field" )
    private String cidade;

}
