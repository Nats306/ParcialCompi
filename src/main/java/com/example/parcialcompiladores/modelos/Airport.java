package com.example.parcialcompiladores.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    @NotNull
    @Getter
    @Setter
    private String name;
    @NotNull
    @Getter
    @Setter
    private String location;
    @NotNull
    @Getter
    @Setter
    private Integer capacity;
    @Setter
    @Getter
    private String owners = "Sofia and Natalia the best owners";
}
