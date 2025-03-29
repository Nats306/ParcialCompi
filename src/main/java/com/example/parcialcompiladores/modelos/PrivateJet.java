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
@Table(name= "jetsPrivados")
public class PrivateJet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String model;
    @Getter
    @Setter
    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false) // Clave foránea
    @JsonIgnore
    private Celebrity owner;

    @OneToMany(mappedBy = "jet_id", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<Flight> vuelosAvion;
}
