package com.parcial.equipo.Service;

import com.parcial.equipo.Model.Equipo;
import com.parcial.equipo.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> obtenerPorId(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Optional<Equipo> actualizar(Long id, Equipo equipoActualizado) {
        return equipoRepository.findById(id).map(equipo -> {
            equipo.setNombre(equipoActualizado.getNombre());
            equipo.setCiudad(equipoActualizado.getCiudad());
            equipo.setFundacion(equipoActualizado.getFundacion());
            return equipoRepository.save(equipo);
        });
    }

    public boolean eliminar(Long id) {
        return equipoRepository.findById(id).map(equipo -> {
            equipoRepository.delete(equipo);
            return true;
        }).orElse(false);
    }
}
