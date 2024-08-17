CREATE TABLE "Empresa" (
  "rut" VARCHAR(10) PRIMARY KEY,
  "nombre" VARCHAR(120),
  "direccion" VARCHAR(120),
  "telefono" VARCHAR(15),
  "correo" VARCHAR(80),
  "web" VARCHAR(50)
);

CREATE TABLE "Herramienta" (
  "id_herramienta" INT PRIMARY KEY,
  "nombre" VARCHAR(120),
  "precio_dia" INT
);

CREATE TABLE "Cliente" (
  "rut" VARCHAR(10) PRIMARY KEY,
  "nombre" VARCHAR(120),
  "correo" VARCHAR(80),
  "direccion" VARCHAR(120),
  "celular" VARCHAR(15)
);

CREATE TABLE "Arriendo" (
  "folio" INT PRIMARY KEY,
  "fecha" DATE,
  "dias" INT
  "valor_dia" INT,
  "garantia" VARCHAR(30),
  "herramienta_id_herramienta" INT,
  "cliente_rut" VARCHAR(10)
);

ALTER TABLE "Arriendo" ADD FOREIGN KEY ("cliente_rut") REFERENCES "Cliente" ("rut");

ALTER TABLE "Arriendo" ADD FOREIGN KEY ("herramienta_id_herramienta") REFERENCES "Herramienta" ("id_herramienta");
