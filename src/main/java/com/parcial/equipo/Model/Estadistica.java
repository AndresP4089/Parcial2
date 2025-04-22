package com.parcial.equipo.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "estadisticas")
public class Estadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido", nullable = false)
    private Partido partido;

    @Column(name = "minutos_jugados", nullable = false)
    private Long minutosJugados;

    @Column(nullable = false)
    private Integer goles;

    @Column(nullable = false)
    private Integer asistencias;

    @Column(name = "tarjetas_amarillas", nullable = false)
    private Integer tarjetasAmarillas;

    @Column(name = "tarjetas_rojas", nullable = false)
    private Integer tarjetasRojas;
}
