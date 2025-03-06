package com.example.parcialcompiladores.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
public class SecurityReport {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @NotNull
    @Getter
    @Setter
    private String reported_by;
    @NotNull
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private boolean is_resolved=false;

    @ManyToOne(fetch = FetchType.LAZY) //un vuelo puede tener varios problemas
    @JoinColumn(name = "Flight_id", nullable = false) // Clave foránea
    @JsonIgnore
    private Flight flight_id;

}
