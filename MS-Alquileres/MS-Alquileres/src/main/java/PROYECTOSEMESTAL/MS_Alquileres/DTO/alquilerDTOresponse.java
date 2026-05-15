package PROYECTOSEMESTAL.MS_Alquileres.DTO;

import java.time.LocalDate;

import PROYECTOSEMESTAL.MS_Alquileres.Modelo.cinta;
import lombok.Data;

@Data
public class alquilerDTOresponse {
    private Long id;

    private cinta cinta;

    private LocalDate fechaAlquiler;

    private LocalDate fechaDevolucion;

    private LocalDate fechaLimite;

    private String devuelto;

    private Double multa;


}
