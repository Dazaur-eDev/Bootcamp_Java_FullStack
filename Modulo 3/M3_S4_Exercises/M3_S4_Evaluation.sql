CREATE TABLE "Empresa" (
  "rut" VARCHAR2(10) PRIMARY KEY,
  "nombre" VARCHAR2(120),
  "direccion" VARCHAR2(120),
  "telefono" VARCHAR2(15),
  "correo" VARCHAR2(80),
  "web" VARCHAR2(50)
);

CREATE TABLE "Herramienta" (
  "id_herramienta" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR(120),
  "precio_dia" NUMBER(12)
);

CREATE TABLE "Cliente" (
  "rut" VARCHAR2(10) PRIMARY KEY,
  "nombre" VARCHAR2(120),
  "correo" VARCHAR2(80),
  "direccion" VARCHAR2(120),
  "celular" VARCHAR2(15)
);

CREATE TABLE "Arriendo" (
  "folio" NUMBER(12) PRIMARY KEY,
  "fecha" DATE,
  "dias" NUMBER(5),
  "valor_dia" NUMBER(12),
  "garantia" VARCHAR2(30),
  "herramienta_id_herramienta" NUMBER(12),
  "cliente_rut" VARCHAR2(10)
);

ALTER TABLE "Arriendo" ADD FOREIGN KEY ("cliente_rut") REFERENCES "Cliente" ("rut");

ALTER TABLE "Arriendo" ADD FOREIGN KEY ("herramienta_id_herramienta") REFERENCES "Herramienta" ("id_herramienta");
