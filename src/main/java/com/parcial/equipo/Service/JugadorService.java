package com.parcial.equipo.Service;

import com.parcial.equipo.Model.Jugador;
import com.parcial.equipo.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> obtenerPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Optional<Jugador> actualizar(Long id, Jugador jugadorActualizado) {
        return jugadorRepository.findById(id).map(jugador -> {
            jugador.setNombre(jugadorActualizado.getNombre());
            jugador.setPosicion(jugadorActualizado.getPosicion());
            jugador.setDorsal(jugadorActualizado.getDorsal());
            jugador.setFechaNacimiento(jugadorActualizado.getFechaNacimiento());
            jugador.setNacionalidad(jugadorActualizado.getNacionalidad());
            jugador.setEquipo(jugadorActualizado.getEquipo());
            return jugadorRepository.save(jugador);
        });
    }

    public boolean eliminar(Long id) {
        return jugadorRepository.findById(id).map(jugador -> {
            jugadorRepository.delete(jugador);
            return true;
        }).orElse(false);
    }
}
