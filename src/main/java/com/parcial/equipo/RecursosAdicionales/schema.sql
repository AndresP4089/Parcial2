CREATE TABLE equipo (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    fundacion DATE NOT NULL
);

CREATE TABLE jugador (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    posicion VARCHAR(50) NOT NULL,
    dorsal INTEGER NOT NULL,
    fecha_na DATE NOT NULL,
    nacionalidad VARCHAR(100) NOT NULL,
    id_equipo INTEGER NOT NULL REFERENCES equipo(id)
);

CREATE TABLE entrenador (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    id_equipo INTEGER NOT NULL REFERENCES equipo(id)
);

CREATE TABLE partido (
    id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    estadio VARCHAR(100) NOT NULL,
    equipo_local INTEGER NOT NULL REFERENCES equipo(id),
    equipo_visita INTEGER NOT NULL REFERENCES equipo(id),
    goles_local INTEGER NOT NULL,
    goles_visita INTEGER NOT NULL
);

CREATE TABLE estadistica (
    id SERIAL PRIMARY KEY,
    id_jugador INTEGER NOT NULL REFERENCES jugador(id),
    id_partido INTEGER NOT NULL REFERENCES partido(id),
    minutos_jugados INTEGER NOT NULL,
    goles INTEGER NOT NULL,
    asistencias INTEGER NOT NULL,
    tarjetas_amarillas INTEGER NOT NULL,
    tarjetas_rojas INTEGER NOT NULL
);
