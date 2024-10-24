CREATE DATABASE Modulo5;

CREATE TABLE alumno (
  id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nombre TEXT NOT NULL,
  apellido TEXT NOT NULL,
  edad INT NOT NULL
);

INSERT INTO
  alumno (nombre, apellido, edad)
VALUES
  ('Juan', 'Pérez', 20),
  ('María', 'González', 22),
  ('Carlos', 'López', 21),
  ('Ana', 'Martínez', 23),
  ('Luis', 'Hernández', 24),
  ('Sofía', 'Ramírez', 22),
  ('Miguel', 'Torres', 25),
  ('Lucía', 'Vargas', 20),
  ('Javier', 'Castro', 21),
  ('Elena', 'Mendoza', 23);