CREATE TABLE "Empresa" (
  "rut" VARCHAR2(10) PRIMARY KEY,
  "nombre" VARCHAR2(120),
  "direccion" VARCHAR2(120),
  "telefono" VARCHAR2(15),
  "correo" VARCHAR2(80),
  "web" VARCHAR2(50)
);

CREATE TABLE "Cliente" (
  "rut" varchar2(10),
  "nombre" VARCHAR2(120),
  "correo" VARCHAR2(80),
  "direccion" VARCHAR2(120),
  "celular" VARCHAR2(15),
  "alta" BOOL(1)
);

CREATE TABLE "Tipo_Vehiculo" (
  "id_tipo_vahiculo" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR2(120)
);

CREATE TABLE "Venta" (
  "folio" NUMBER(12) PRIMARY KEY,
  "fecha" DATE,
  "monto" NUMBER(12),
  "vehiculo_id_vehiculo" NUMBER(12),
  "cliente_rut" VARCHAR2(10)
);

CREATE TABLE "Vehiculo" (
  "id_vehiculo" NUMBER(12) PRIMARY KEY,
  "patente" VARCHAR2(10),
  "marca" VARCHAR2(20),
  "modelo" VARCHAR2(20),
  "color" VARCHAR2(15),
  "precio" NUMBER(12),
  "frecuencia_mantencion" NUMBER(5),
  "marca_id_marca" NUMBER(12),
  "tipo_vehiculo_id_tipo_vehiculo" NUMBER(12)
);

CREATE TABLE "Mantencion" (
  "id_mantencion" NUMBER(12) PRIMARY KEY,
  "fecha" DATE,
  "trabajos_realizados" VARCHAR2(1000),
  "venta_folio" NUMBER(12)
);

CREATE TABLE "Marca" (
  "id_marca" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR2(120)
);

ALTER TABLE "Venta" ADD FOREIGN KEY ("cliente_rut") REFERENCES "Cliente" ("rut");

ALTER TABLE "Vehiculo" ADD FOREIGN KEY ("id_vehiculo") REFERENCES "Venta" ("vehiculo_id_vehiculo");

ALTER TABLE "Vehiculo" ADD FOREIGN KEY ("tipo_vehiculo_id_tipo_vehiculo") REFERENCES "Tipo_Vehiculo" ("id_tipo_vahiculo");

ALTER TABLE "Vehiculo" ADD FOREIGN KEY ("marca_id_marca") REFERENCES "Marca" ("id_marca");

ALTER TABLE "Mantencion" ADD FOREIGN KEY ("venta_folio") REFERENCES "Venta" ("folio");
