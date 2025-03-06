package com.example.parcialcompiladores.modelos;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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
    @NotNull
    @Getter
    @Setter
    private String name;
    @NotNull
    @Getter
    @Setter
    private String profession;
    @Getter
    @Setter
    private double netWorth;
    @Getter
    @Setter
    private boolean suspicious = false;


}
