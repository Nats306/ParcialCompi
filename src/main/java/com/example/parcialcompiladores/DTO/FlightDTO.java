package com.example.parcialcompiladores.DTO;

// import com.example.parcialcompiladores.modelos.Purpose;
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
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private Long celebrityId;
    private Long jetId;
    // private Purpose purpose; falta añadir esto, no se como
}
