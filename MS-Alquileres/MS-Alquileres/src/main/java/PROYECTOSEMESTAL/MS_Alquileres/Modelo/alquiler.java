package PROYECTOSEMESTAL.MS_Alquileres.Modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name = "alquiler")
@Data
@Entity
public class alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuario Usuario;


    @ManyToOne
    @JoinColumn(name = "cinta_id", nullable = false)
    private cinta cinta;

    private LocalDate fechaAlquiler;

    private LocalDate fechaDevolucion;

    private LocalDate fechaLimite;

    private String devuelto;

    private Double multa;

}
