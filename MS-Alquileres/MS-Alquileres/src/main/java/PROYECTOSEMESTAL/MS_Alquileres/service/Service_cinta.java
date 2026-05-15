package PROYECTOSEMESTAL.MS_Alquileres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import PROYECTOSEMESTAL.MS_Alquileres.Modelo.cinta;
import PROYECTOSEMESTAL.MS_Alquileres.repository.repository_cinta;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class Service_cinta {
private repository_cinta Repository;

    public List<cinta> obtenerTodas() {
        return Repository.findAll();
    }

    public Optional<cinta> obtenerPorId(Long id) {
        return Repository.findById(id);
    }

    public cinta guardar(cinta cinta) {
        return Repository.save(cinta);
    }

    public void eliminar(Long id) {
        Repository.deleteById(id);
    }
}

