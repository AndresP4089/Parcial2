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
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String posicion;

    @Column(nullable = false)
    private Long dorsal; // Numero de camiseta

    @Column(name = "fecha_na", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 100)
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @JsonIgnore
    @OneToMany(mappedBy = "jugador")
    private List<Estadistica> estadisticas;
}
