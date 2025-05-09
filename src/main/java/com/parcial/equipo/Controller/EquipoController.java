package com.parcial.equipo.Controller;

import com.parcial.equipo.Model.Equipo;
import com.parcial.equipo.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @GetMapping("/listar")
    public List<Equipo> listarTodos() {
        return equipoService.obtenerTodos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Equipo> obtenerPorId(@PathVariable Long id) {
        return equipoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoService.guardar(equipo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.actualizar(id, equipo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return equipoService.eliminar(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/{idEquipo}/goles")
    public Integer totalGolesPorEquipo(@Param("idEquipo") Long idEquipo) {
        return equipoService.totalGolesPorEquipo(idEquipo);
    }
}
