package com.example.parcialcompiladores.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name= "celebridades")
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @NotNull(message = "El tipo de id no puede ser nulo")
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
    @Min(value = 0, message = "El capital neto no puede ser negativo")
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