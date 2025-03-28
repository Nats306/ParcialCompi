package com.example.parcialcompiladores.DTO;

import com.example.parcialcompiladores.modelos.TipoID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CelebrityDTO {
    private String id;
    private String tipoId;  //igual que en flight, no me deja manejarlo con ese enum
    private String name;
    private String profession;
    private double netWorth;
    private boolean suspicious;
}
