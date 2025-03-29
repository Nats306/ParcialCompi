package com.example.parcialcompiladores.DTO;

import com.example.parcialcompiladores.modelos.TipoID;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "El tipo de id no puede ser nulo")
    private TipoID tipoId;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @NotBlank(message = "La profesion no puede estar vacía")
    private String profession;
    @Min(value = 0, message = "El capital neto no puede ser negativo")
    private double netWorth;
    private boolean suspicious = false;
}
