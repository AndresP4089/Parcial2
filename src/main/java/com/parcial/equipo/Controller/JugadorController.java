package com.parcial.equipo.Controller;

import com.parcial.equipo.Model.Jugador;
import com.parcial.equipo.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> listarTodos() {
        return jugadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerPorId(@PathVariable Long id) {
        return jugadorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorService.guardar(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable Long id, @RequestBody Jugador jugador) {
        return jugadorService.actualizar(id, jugador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return jugadorService.eliminar(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
