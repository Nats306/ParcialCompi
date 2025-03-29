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
@Table(name= "celebridades")
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private TipoID tipoId;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String profession;
    @Getter
    @Setter
    private double netWorth;
    @Getter
    @Setter
    private boolean suspicious = false;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<PrivateJet> jets;

    @OneToMany(mappedBy = "celebrity", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<Flight> flights;
}