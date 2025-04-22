package com.parcial.equipo.Service;

import com.parcial.equipo.Model.Entrenador;
import com.parcial.equipo.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> obtenerPorId(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Optional<Entrenador> actualizar(Long id, Entrenador entrenadorActualizado) {
        return entrenadorRepository.findById(id).map(entrenador -> {
            entrenador.setNombre(entrenadorActualizado.getNombre());
            entrenador.setEspecialidad(entrenadorActualizado.getEspecialidad());
            entrenador.setEquipo(entrenadorActualizado.getEquipo());
            return entrenadorRepository.save(entrenador);
        });
    }

    public boolean eliminar(Long id) {
        return entrenadorRepository.findById(id).map(entrenador -> {
            entrenadorRepository.delete(entrenador);
            return true;
        }).orElse(false);
    }
}
