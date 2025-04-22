package com.parcial.equipo.Repository;

import com.parcial.equipo.Model.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Long> {
}
