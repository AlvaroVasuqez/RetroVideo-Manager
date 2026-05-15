package com.RetroVideoManager.Pago.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.RetroVideoManager.Pago.DTO.pagoRequestDTO;
import com.RetroVideoManager.Pago.DTO.pagoResponseDTO;
import com.RetroVideoManager.Pago.Repository.pagoRepository;
import com.RetroVideoManager.Pago.model.PagoModel;

@Service
@Transactional
public class pagoService {
    @Autowired
    private pagoRepository pagoRepository;

    public List<pagoResponseDTO> findAll(){
        return pagoRepository.findAll().stream().map(pago -> {
            pagoResponseDTO response = new pagoResponseDTO();
            response.setIdPago(pago.getIdPago());
            response.setMetodoPago(pago.getMetodoPago());
            response.setMonto(pago.getMonto());
            response.setFechaPago(pago.getFechaPago());
            response.setEstadoPago(pago.getEstadoPago());
            response.setNroTarjeta(pago.getNroTarjeta());
            return response;
        }).toList();
    }

    public pagoResponseDTO findById(Integer id){
        return pagoRepository.findById(id.longValue()).map(pago -> {
            pagoResponseDTO response = new pagoResponseDTO();
            response.setIdPago(pago.getIdPago());
            response.setMetodoPago(pago.getMetodoPago());
            response.setMonto(pago.getMonto());
            response.setFechaPago(pago.getFechaPago());
            response.setEstadoPago(pago.getEstadoPago());
            response.setNroTarjeta(pago.getNroTarjeta());
            return response;
        }).orElse(null);
    }

    public void deleteById(Integer id){
        pagoRepository.deleteById(id.longValue());
    }

    public pagoResponseDTO save(pagoRequestDTO pago){
        PagoModel guerdarPago = new PagoModel();
        guerdarPago.setIdPago(pago.getIdPago());
        guerdarPago.setMetodoPago(pago.getMetodoPago());
        guerdarPago.setMonto(pago.getMonto());
        guerdarPago.setFechaPago(pago.getFechaPago());
        guerdarPago.setEstadoPago(pago.getEstadoPago());
        guerdarPago.setNroTarjeta(pago.getNroTarjeta());
        return toResponseDTO(pagoRepository.save(guerdarPago));
    }

    private pagoResponseDTO toResponseDTO(PagoModel pago) {
        pagoResponseDTO response = new pagoResponseDTO();
        response.setIdPago(pago.getIdPago());
        response.setMetodoPago(pago.getMetodoPago());
        response.setMonto(pago.getMonto());
        response.setFechaPago(pago.getFechaPago());
        response.setEstadoPago(pago.getEstadoPago());
        response.setNroTarjeta(pago.getNroTarjeta());
        return response;
    }

    public pagoResponseDTO update(Integer id, pagoRequestDTO pago){
        return pagoRepository.findById(id.longValue()).map(pagoExistente -> {
            pagoExistente.setMetodoPago(pago.getMetodoPago());
            pagoExistente.setMonto(pago.getMonto());
            pagoExistente.setFechaPago(pago.getFechaPago());
            pagoExistente.setEstadoPago(pago.getEstadoPago());
            pagoExistente.setNroTarjeta(pago.getNroTarjeta());
            return toResponseDTO(pagoRepository.save(pagoExistente));
        }).orElse(null);
    }
    
}
