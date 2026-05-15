package com.RetroVideoManager.Pago.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class pagoRequestDTO {
    @NotNull(message = "El ID del pago es obligatorio")
    private Integer idPago;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago; // Ejemplo: "Tarjeta de Crédito", "PayPal", "Efectivo", "Cheque" "Tarjeta de debito" etc.

    @NotNull(message = "El monto es obligatorio")
    private Double monto;

    @NotBlank(message = "La fecha de pago es obligatoria")
    private String fechaPago;

    @NotBlank(message = "El estado del pago es obligatorio")
    private String estadoPago; // Ejemplo: "Pendiente", "Completado", "Fallido", "Reembolsado" etc.

    @NotBlank(message = "El número de tarjeta es obligatorio")
    private String nroTarjeta; // debito o credito.
}
