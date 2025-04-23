package com.parcial.equipo.Controller;

import com.parcial.equipo.Model.Partido;
import com.parcial.equipo.Repository.ResultadoPartidoDTO;
import com.parcial.equipo.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {
    @Autowired
    private PartidoService partidoService;

    @GetMapping("/listar")
    public List<Partido> listarTodos() {
        return partidoService.obtenerTodos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Partido> obtenerPorId(@PathVariable Long id) {
        return partidoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public Partido crear(@RequestBody Partido partido) {
        return partidoService.guardar(partido);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Partido> actualizar(@PathVariable Long id, @RequestBody Partido partido) {
        return partidoService.actualizar(id, partido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return partidoService.eliminar(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/resultados")
    public List<ResultadoPartidoDTO> obtenerResultadosPartidos() {
        return partidoService.obtenerResultadosPartidos();
    }
}
