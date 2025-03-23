package com.example.parcialcompiladores.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
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
    @NotBlank(message = "La capacidad no puede ser nula")
    @Min(value = 0, message = "La capacidad no puede ser negativa")
    @Getter
    @Setter
    private Integer capacity;
    @Setter
    @Getter
    private String owners = "Sofia and Natalia the best owners";
}
