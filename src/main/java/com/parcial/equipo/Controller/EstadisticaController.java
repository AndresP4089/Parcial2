package com.parcial.equipo.Controller;

import com.parcial.equipo.Model.Estadistica;
import com.parcial.equipo.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {
    @Autowired
    private EstadisticaService estadisticaService;

    @GetMapping
    public List<Estadistica> listarTodas() {
        return estadisticaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadistica> obtenerPorId(@PathVariable Long id) {
        return estadisticaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estadistica crear(@RequestBody Estadistica estadistica) {
        return estadisticaService.guardar(estadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estadistica> actualizar(@PathVariable Long id, @RequestBody Estadistica estadistica) {
        return estadisticaService.actualizar(id, estadistica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return estadisticaService.eliminar(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
