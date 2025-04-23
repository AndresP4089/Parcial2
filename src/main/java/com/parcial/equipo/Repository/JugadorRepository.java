package com.parcial.equipo.Repository;

import com.parcial.equipo.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    // Obtener todos los jugadores de un equipo
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> obtenerJugadoresPorEquipo(@Param("idEquipo") Long idEquipo);
    // Obtener todos los jugadores que marcaron mas de x goles
    @Query(value = """
        SELECT j.* FROM jugador j
        JOIN estadisticas e ON j.id = e.id_jugador
        GROUP BY j.id
        HAVING SUM(e.goles) > :numGoles
    """, nativeQuery = true)
    List<Jugador> obtenerJugadoresPorGoles(int numGoles);
}
