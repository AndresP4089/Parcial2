package com.parcial.equipo.Repository;

import java.time.LocalDate;


// Esta interfaz se creó para devolver un objeto en
// última native query: obtener resultdos de los partidos
// con los nombre de los equipos

public interface ResultadoPartidoDTO {
    LocalDate getFecha();
    String getEstadio();
    String getEquipoLocal();
    String getEquipoVisita();
    Integer getGolesLocal();
    Integer getGolesVisita();
}
