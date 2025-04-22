package com.parcial.equipo.Service;

import com.parcial.equipo.Model.Estadistica;
import com.parcial.equipo.Repository.EstadisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaService {
    @Autowired
    private EstadisticaRepository estadisticaRepository;

    public List<Estadistica> obtenerTodas() {
        return estadisticaRepository.findAll();
    }

    public Optional<Estadistica> obtenerPorId(Long id) {
        return estadisticaRepository.findById(id);
    }

    public Estadistica guardar(Estadistica estadistica) {
        return estadisticaRepository.save(estadistica);
    }

    public Optional<Estadistica> actualizar(Long id, Estadistica estadisticaActualizada) {
        return estadisticaRepository.findById(id).map(estadistica -> {
            estadistica.setJugador(estadisticaActualizada.getJugador());
            estadistica.setPartido(estadisticaActualizada.getPartido());
            estadistica.setMinutosJugados(estadisticaActualizada.getMinutosJugados());
            estadistica.setGoles(estadisticaActualizada.getGoles());
            estadistica.setAsistencias(estadisticaActualizada.getAsistencias());
            estadistica.setTarjetasAmarillas(estadisticaActualizada.getTarjetasAmarillas());
            estadistica.setTarjetasRojas(estadisticaActualizada.getTarjetasRojas());
            return estadisticaRepository.save(estadistica);
        });
    }

    public boolean eliminar(Long id) {
        return estadisticaRepository.findById(id).map(estadistica -> {
            estadisticaRepository.delete(estadistica);
            return true;
        }).orElse(false);
    }
}
