package com.example.parcialcompiladores.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @NotBlank(message = "El aeropuerto de despegada no puede estar vació")
    @Getter
    @Setter
    private String departure_airport;
    @NotBlank(message = "El aeropuerto destino no puede estar vacío")
    @Getter
    @Setter
    private String arrival_airport;
    @NotBlank(message = "El tiempo de salida no puede estar vacío")
    @Getter
    @Setter
    private String departure_time;
    @NotBlank(message = "El tiempo de llegada no puede estar vacío")
    @Getter
    @Setter
    private String arrival_time;



    @OneToMany(mappedBy = "flight_id", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SecurityReport> reportes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "celebrity_id", nullable = false)
    @JsonIgnore
    private Celebrity celebrity_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jet_id", nullable = false)
    @JsonIgnore
    private PrivateJet jet_id;

    @Enumerated(EnumType.STRING)
    private Purpose purpose;
}