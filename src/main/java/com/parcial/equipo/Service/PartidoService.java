package com.parcial.equipo.Service;

import com.parcial.equipo.Model.Partido;
import com.parcial.equipo.Repository.PartidoRepository;
import com.parcial.equipo.Repository.ResultadoPartidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> obtenerTodos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> obtenerPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Optional<Partido> actualizar(Long id, Partido partidoActualizado) {
        return partidoRepository.findById(id).map(partido -> {
            partido.setFecha(partidoActualizado.getFecha());
            partido.setEstadio(partidoActualizado.getEstadio());
            partido.setEquipoLocal(partidoActualizado.getEquipoLocal());
            partido.setEquipoVisita(partidoActualizado.getEquipoVisita());
            partido.setGolesLocal(partidoActualizado.getGolesLocal());
            partido.setGolesVisita(partidoActualizado.getGolesVisita());
            return partidoRepository.save(partido);
        });
    }

    public boolean eliminar(Long id) {
        return partidoRepository.findById(id).map(partido -> {
            partidoRepository.delete(partido);
            return true;
        }).orElse(false);
    }

    public List<ResultadoPartidoDTO> obtenerResultadosPartidos() {
        return partidoRepository.obtenerResultadosPartidos();
    }
}
