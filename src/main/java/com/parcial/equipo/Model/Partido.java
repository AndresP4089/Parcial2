package com.parcial.equipo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "partido")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 100)
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita", nullable = false)
    private Equipo equipoVisita;

    @Column(nullable = false)
    private Integer golesLocal;

    @Column(nullable = false)
    private Integer golesVisita;

    @JsonIgnore
    @OneToMany(mappedBy = "partido")
    private List<Estadistica> estadisticas;
}
