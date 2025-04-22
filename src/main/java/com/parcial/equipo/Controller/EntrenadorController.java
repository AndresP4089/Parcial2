package com.parcial.equipo.Controller;

import com.parcial.equipo.Model.Entrenador;
import com.parcial.equipo.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/listar")
    public List<Entrenador> listarTodos() {
        return entrenadorService.obtenerTodos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Entrenador> obtenerPorId(@PathVariable Long id) {
        return entrenadorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear/{id}")
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardar(entrenador);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Entrenador> actualizar(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        return entrenadorService.actualizar(id, entrenador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return entrenadorService.eliminar(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
