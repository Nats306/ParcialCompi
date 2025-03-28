package com.example.parcialcompiladores.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name= "aeropuertos")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Getter
    @Setter
    private String name;
    @NotBlank(message = "La locación no puede estar vacía")
    @Getter
    @Setter
    private String location;
    @NotNull(message = "Capacity cannot be null")
    @Min(value = 0, message = "La capacidad no puede ser negativa")
    @Getter
    @Setter
    private Integer capacity;
    @Setter
    @Getter
    private String owners = "Sofia and Natalia the best owners";
}
