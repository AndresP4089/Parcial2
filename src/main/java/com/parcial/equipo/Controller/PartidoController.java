package com.parcial.equipo.Controller;

import com.parcial.equipo.Model.Partido;
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

    @GetMapping
    public List<Partido> listarTodos() {
        return partidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtenerPorId(@PathVariable Long id) {
        return partidoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido crear(@RequestBody Partido partido) {
        return partidoService.guardar(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizar(@PathVariable Long id, @RequestBody Partido partido) {
        return partidoService.actualizar(id, partido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return partidoService.eliminar(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
