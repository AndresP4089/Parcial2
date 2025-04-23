package com.parcial.equipo.Repository;

import com.parcial.equipo.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    // Obtener los resultados de partidos indicando los nombre de los equipos
    @Query(value = """
    SELECT 
        p.fecha AS fecha,
        p.estadio AS estadio,
        el.nombre AS equipoLocal,
        ev.nombre AS equipoVisita,
        p.goles_local AS golesLocal,
        p.goles_visita AS golesVisita
    FROM partido p
    JOIN equipo el ON p.equipo_local = el.id
    JOIN equipo ev ON p.equipo_visita = ev.id
    """, nativeQuery = true)
    List<ResultadoPartidoDTO> obtenerResultadosPartidos();


}
