
-- FINAL DRILLING Modulo 3 Bases de Datos
-- Ejercicio Numero 1
-- ____________________________________________________________________________________
-- Comandos usados en dbDiagram

CREATE TABLE "Biblioteca" (
  "id" SERIAL PRIMARY KEY,
  "nombre" VARCHAR [NOT NULL],
  "direccion" VARCHAR(100) [NOT NULL],
  "email" VARCHAR(100) [NOT NULL]
);

CREATE TABLE "Socios" (
  "rut" VARCHAR(12) PRIMARY KEY,
  "nombre" VARCHAR(50) [NOT NULL],
  "telefono" VARCHAR(25) [NOT NULL],
  "direccion" VARCHAR(100),
  "email" VARCHAR(100),
  "id_estadoSocio" SERIAL [NOT NULL],
  "categoriaSocio" CHAR(1) [NOT NULL]
);

CREATE TABLE "Libros" (
  "id" SERIAL PRIMARY KEY,
  "titulo" VARCHAR(50) [NOT NULL],
  "autor" VARCHAR(50) [NOT NULL],
  "id_tema" SERIAL [NOT NULL],
  "fechaEdicion" DATE [NOT NULL],
  "id_editorial" VARCHAR(50) [NOT NULL],
  "totalEjemplares" INT,
  "ejemplaresDisponibles" INT
);

CREATE TABLE "Control_Ejemplares" (
  "id" SERIAL PRIMARY KEY,
  "id_libro" SERIAL [NOT NULL],
  "id_descripcionEstadoEjemplar" SERIAL [NOT NULL],
  "categoriaEjemplar" CHAR(1) [NOT NULL]
);

CREATE TABLE "Prestamos" (
  "id" SERIAL PRIMARY KEY,
  "id_ejemplar" SERIAL [NOT NULL],
  "id_socio" VARCHAR(12) [NOT NULL],
  "fechaDevolucion" DATE [NOT NULL],
  "fechaPrestamo" DATE [NOT NULL],
  "descripcion" VARCHAR(250)
);

CREATE TABLE "Estado_ejemplares" (
  "id" SERIAL PRIMARY KEY,
  "descripcionEstadoEjemplar" VARCHAR(80) [NOT NULL]
);

CREATE TABLE "Estado_socio" (
  "id" SERIAL PRIMARY KEY,
  "descripcionEstadoSocio" VARCHAR(80) [NOT NULL]
);

CREATE TABLE "Editoriales" (
  "id" SERIAL PRIMARY KEY,
  "nombre" VARCHAR(100) [NOT NULL]
);

CREATE TABLE "Tema_libros" (
  "id" SERIAL PRIMARY KEY,
  "nombreTema" VARCHAR(100) [NOT NULL]
);

ALTER TABLE "Socios" ADD FOREIGN KEY ("id_estadoSocio") REFERENCES "Estado_socio" ("id");

ALTER TABLE "Libros" ADD FOREIGN KEY ("id_tema") REFERENCES "Tema_libros" ("id");

ALTER TABLE "Libros" ADD FOREIGN KEY ("id_editorial") REFERENCES "Editoriales" ("id");

ALTER TABLE "Prestamos" ADD FOREIGN KEY ("id_ejemplar") REFERENCES "Control_Ejemplares" ("id");

ALTER TABLE "Control_Ejemplares" ADD FOREIGN KEY ("id_descripcionEstadoEjemplar") REFERENCES "Estado_ejemplares" ("id");

ALTER TABLE "Socios" ADD FOREIGN KEY ("rut") REFERENCES "Prestamos" ("id_socio");

ALTER TABLE "Control_Ejemplares" ADD FOREIGN KEY ("id_libro") REFERENCES "Libros" ("id");


-- _______________________________________________________________________________________________________________
-- Comandos para Postgress! 

CREATE TABLE estado_socio (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  descripcionestadosocio TEXT NOT NULL
);

CREATE TABLE estado_ejemplares (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  descripcionestadoejemplar TEXT NOT NULL
);

CREATE TABLE editoriales (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nombre TEXT NOT NULL
);

CREATE TABLE tema_libros (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nombretema TEXT NOT NULL
);

CREATE TABLE biblioteca (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nombre TEXT NOT NULL,
  direccion TEXT NOT NULL,
  email TEXT NOT NULL
);

CREATE TABLE socios (
  rut TEXT PRIMARY KEY,
  nombre TEXT NOT NULL,
  telefono TEXT NOT NULL,
  direccion TEXT,
  email TEXT,
  id_estadosocio BIGINT NOT NULL,
  categoriasocio CHAR(1) NOT NULL,
  FOREIGN KEY (id_estadosocio) REFERENCES estado_socio (id)
);

CREATE TABLE libros (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  titulo TEXT NOT NULL,
  autor TEXT NOT NULL,
  id_tema BIGINT NOT NULL,
  fechaedicion DATE NOT NULL,
  id_editorial BIGINT NOT NULL,
  totalejemplares int,
  ejemplaresdisponibles int,
  FOREIGN KEY (id_tema) REFERENCES tema_libros (id),
  FOREIGN KEY (id_editorial) REFERENCES editoriales (id)
);

CREATE TABLE control_ejemplares (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  id_libro BIGINT NOT NULL,
  id_descripcionestadoejemplar BIGINT NOT NULL,
  categoriaejemplar CHAR(1) NOT NULL,
  FOREIGN KEY (id_libro) REFERENCES Libros (id),
  FOREIGN KEY (id_descripcionestadoejemplar) REFERENCES estado_ejemplares (id)
);

CREATE TABLE prestamos (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  id_ejemplar BIGINT NOT NULL,
  id_socio TEXT NOT NULL,
  fechadevolucion DATE NOT NULL,
  fechaprestamo DATE NOT NULL,
  descripcion TEXT,
  FOREIGN KEY (id_ejemplar) REFERENCES control_ejemplares (id),
  FOREIGN KEY (id_socio) REFERENCES socios (rut)
);