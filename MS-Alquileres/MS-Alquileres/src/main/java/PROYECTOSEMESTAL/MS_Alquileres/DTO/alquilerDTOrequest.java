package PROYECTOSEMESTAL.MS_Alquileres.DTO;

import java.time.LocalDate;

import PROYECTOSEMESTAL.MS_Alquileres.Modelo.cinta;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class alquilerDTOrequest {
    

    @NotNull(message = "La cinta es obligatoria")
    @Min(value = 1, message = "La cinta debe ser válida")
    private cinta cinta;

    @NotNull(message = "La fecha de alquiler es obligatoria")
    private LocalDate fechaAlquiler;

    private LocalDate fechaDevolucion;

    @NotNull(message = "La fecha límite es obligatoria")
    private LocalDate fechaLimite;

    private String devuelto;

    @NotNull(message = "La multa es obligatoria")
    @Min(value = 0, message = "La multa no puede ser negativa")
    private Double multa;
}
