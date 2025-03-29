package com.example.parcialcompiladores.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name= "reportesdeSeguridad")
public class SecurityReport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String reported_by;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private boolean resolved=false;

    @ManyToOne(fetch = FetchType.LAZY) //un vuelo puede tener varios problemas
    @JoinColumn(name = "Flight_id", nullable = false) // Clave foránea
    @JsonIgnore
    private Flight flight;

}
