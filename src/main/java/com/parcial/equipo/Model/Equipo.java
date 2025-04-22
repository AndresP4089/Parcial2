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
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false)
    private LocalDate fundacion;

    @JsonIgnore
    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    @JsonIgnore
    @OneToMany(mappedBy = "equipo")
    private List<Entrenador> entrenadores;

    @JsonIgnore
    @OneToMany(mappedBy = "equipoLocal")
    private List<Partido> partidosLocal;

    @JsonIgnore
    @OneToMany(mappedBy = "equipoVisita")
    private List<Partido> partidosVisita;
}
