package com.parcial.equipo.Repository;

import com.parcial.equipo.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    // Obtener los goles marcados por un equipo en todos sus partidos
    @Query(value = """
    SELECT 
        COALESCE(SUM(
            CASE 
                WHEN p.equipo_local = :equipoId THEN p.goles_local
                WHEN p.equipo_visita = :equipoId THEN p.goles_visita
                ELSE 0
            END
        ), 0)
    FROM partido p
    WHERE p.equipo_local = :equipoId OR p.equipo_visita = :equipoId
""", nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("equipoId") Long equipoId);
}
