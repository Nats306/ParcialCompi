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
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String location;
    @Getter
    @Setter
    private Integer capacity;
    @Setter
    @Getter
    private String owners = "Sofia and Natalia the best owners";
}
