package PROYECTOSEMESTAL.MS_Alquileres.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PROYECTOSEMESTAL.MS_Alquileres.service.Service_usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import PROYECTOSEMESTAL.MS_Alquileres.DTO.UsuarioDTOResponse;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor

public class controller_usuario {
    private Service_usuario service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTOResponse>> listar(){
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> findById(@PathVariable Long id) {
        try {
            UsuarioDTOResponse usuario = service.findById(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    

    
    @PostMapping
    public ResponseEntity<UsuarioDTOResponse> crear(@Valid @RequestBody UsuarioDTOResponse usuario) {
        UsuarioDTOResponse nuevo = service.save(usuario);
        return ResponseEntity.status(201).body(nuevo);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTOResponse> actualizar(@PathVariable Long id, @RequestBody UsuarioDTOResponse usuario){
        try {
            service.findById(id);
            UsuarioDTOResponse usuarioActualizado = service.update(id, usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.noContent().build(); 
    }
}

