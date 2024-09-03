

-- FINAL DRILLING Modulo 3
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
  id bigint primary key generated always as identity,
  descripcionestadosocio text NOT NULL
);

CREATE TABLE estado_ejemplares (
  id bigint primary key generated always as identity,
  descripcionestadoejemplar text NOT NULL
);

CREATE TABLE editoriales (
  id bigint primary key generated always as identity,
  nombre text NOT NULL
);

CREATE TABLE tema_libros (
  id bigint primary key generated always as identity,
  nombretema text NOT NULL
);

CREATE TABLE biblioteca (
  id bigint primary key generated always as identity,
  nombre text NOT NULL,
  direccion text NOT NULL,
  email text NOT NULL
);

CREATE TABLE socios (
  rut text primary key,
  nombre text NOT NULL,
  telefono text NOT NULL,
  direccion text,
  email text,
  id_estadosocio bigint NOT NULL,
  categoriasocio char(1) NOT NULL,
  foreign key (id_estadosocio) references estado_socio (id)
);

CREATE TABLE libros (
  id bigint primary key generated always as identity,
  titulo text NOT NULL,
  autor text NOT NULL,
  id_tema bigint NOT NULL,
  fechaedicion date NOT NULL,
  id_editorial bigint NOT NULL,
  totalejemplares int,
  ejemplaresdisponibles int,
  foreign key (id_tema) references tema_libros (id),
  foreign key (id_editorial) references editoriales (id)
);

CREATE TABLE control_ejemplares (
  id bigint primary key generated always as identity,
  id_libro bigint NOT NULL,
  id_descripcionestadoejemplar bigint NOT NULL,
  categoriaejemplar char(1) NOT NULL,
  foreign key (id_libro) references libros (id),
  foreign key (id_descripcionestadoejemplar) references estado_ejemplares (id)
);

CREATE TABLE prestamos (
  id bigint primary key generated always as identity,
  id_ejemplar bigint NOT NULL,
  id_socio text NOT NULL,
  fechadevolucion date NOT NULL,
  fechaprestamo date NOT NULL,
  descripcion text,
  foreign key (id_ejemplar) references control_ejemplares (id),
  foreign key (id_socio) references socios (rut)
);


--____________________________________________________________________________________________________
-- Ejercicio Numero 2
-- Construir las consultas para insertar, modificar y eliminar un PROVEEDOR, COMPRA y DETCOMPRA


-- Insertar proveedor 
INSERT INTO Proveedor VALUES ('77656624-8', 'ProovedorSur');
-- Modificar proveedor
UPDATE Proveedor 
SET 
  nombre = 'ProveedorSurChile'
WHERE
  rut = '77656624-8';
-- Eliminar proveedor
DELETE FROM Proveedor
WHERE 
  rut = '77656624-8';

