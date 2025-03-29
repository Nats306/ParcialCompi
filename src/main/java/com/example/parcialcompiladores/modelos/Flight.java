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
@Table(name= "vuelos")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String departure_airport;
    @Getter
    @Setter
    private String arrival_airport;
    @Getter
    @Setter
    private String departure_time;
    @Getter
    @Setter
    private String arrival_time;



    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SecurityReport> reportes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "celebrity_id", nullable = false)
    @JsonIgnore
    private Celebrity celebrity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jet_id", nullable = false)
    @JsonIgnore
    private PrivateJet jet;

    @Enumerated(EnumType.STRING)
    private Purpose purpose;
}