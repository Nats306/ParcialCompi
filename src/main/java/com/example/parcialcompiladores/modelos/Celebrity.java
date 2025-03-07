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
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @NotBlank(message = "El tipo de id no puede estar vacío")
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private TipoID tipoId;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Getter
    @Setter
    private String name;
    @NotBlank(message = "La profesion no puede estar vacía")
    @Getter
    @Setter
    private String profession;
    @Getter
    @Setter
    private double netWorth;
    @Getter
    @Setter
    private boolean suspicious = false;

    @OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<PrivateJet> jets;

    @OneToMany(mappedBy = "celebrity_id", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<Flight> vuelosCelebridad;



}

enum TipoID{
    CC, TI, CE, PASAPORTE;
}