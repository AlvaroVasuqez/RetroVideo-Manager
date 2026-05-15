package com.RetroVideoManager.Pago.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RetroVideoManager.Pago.DTO.pagoResponseDTO;
import com.RetroVideoManager.Pago.Service.pagoService;
import com.RetroVideoManager.Pago.DTO.pagoRequestDTO;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/v1/pagos")
public class pagoController {

    @Autowired
    private pagoService pagoService;

    @GetMapping ResponseEntity<List<pagoResponseDTO>> findAll(){
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<pagoResponseDTO> findById(@PathVariable Integer id){
        pagoResponseDTO pago = pagoService.findById(id);
        if (pago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<pagoResponseDTO> save(@RequestBody pagoRequestDTO  pagoRequestDTO){
        pagoResponseDTO savedPago = pagoService.save(pagoRequestDTO);
        return ResponseEntity.status(201).body(savedPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<pagoResponseDTO> update(@PathVariable Integer id, @RequestBody pagoRequestDTO pagoRequestDTO){
        pagoResponseDTO updatedPago = pagoService.update(id, pagoRequestDTO);
        if (updatedPago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPago);
    }
}