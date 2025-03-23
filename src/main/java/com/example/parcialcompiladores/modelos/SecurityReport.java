package com.example.parcialcompiladores.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
public class SecurityReport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @NotBlank(message = "Se debe poner quien hizo el reporte")
    @Getter
    @Setter
    private String reported_by;
    @NotBlank(message = "La descripción no puede ser nula")
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private boolean resolved=false;

    @ManyToOne(fetch = FetchType.LAZY) //un vuelo puede tener varios problemas
    @JoinColumn(name = "Flight_id", nullable = false) // Clave foránea
    @JsonIgnore
    private Flight flight_id;

}
