package com.RetroVideoManager.Pago.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoModel {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer idPago;
    
    @Column(nullable = false)
    private String metodoPago; // Ejemplo: "Tarjeta de Crédito", "PayPal", "Efectivo", "Cheque" "Tarjeta de debito" etc.

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private String fechaPago;

    @Column(nullable = false)
    private String estadoPago; // Ejemplo: "Pendiente", "Completado", "Fallido", "Reembolsado" etc.

    @Column(nullable = true)
    private String nroTarjeta; // debito o credito.

}
