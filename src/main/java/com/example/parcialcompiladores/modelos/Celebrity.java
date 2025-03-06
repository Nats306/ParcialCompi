package com.example.parcialcompiladores.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.UUID;

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
