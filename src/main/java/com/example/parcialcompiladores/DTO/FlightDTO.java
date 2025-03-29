package com.example.parcialcompiladores.DTO;

import com.example.parcialcompiladores.modelos.Purpose;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDTO {

    private String id;

    @NotBlank(message = "El aeropuerto de despegada no puede estar vació")
    private String departureAirport;

    @NotBlank(message = "El aeropuerto destino no puede estar vacío")
    private String arrivalAirport;

    @NotBlank(message = "El tiempo de salida no puede estar vacío")
    private String departureTime;

    @NotBlank(message = "El tiempo de llegada no puede estar vacío")
    private String arrivalTime;
    private String celebrityId;
    private String jetId;
    private Purpose purpose;
}
