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

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @NotNull
    @Getter
    @Setter
    private String departure_airport;
    @NotNull
    @Getter
    @Setter
    private String arrival_airport;
    @NotNull
    @Getter
    @Setter
    private String departure_time;
    @NotNull
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
}
