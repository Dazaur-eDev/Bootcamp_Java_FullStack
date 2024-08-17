CREATE TABLE "Empresa" (
  "rut" VARCHAR(10) PRIMARY KEY,
  "nombre" VARCHAR(120),
  "direccion" VARCHAR(120),
  "telefono" VARCHAR(15),
  "correo" VARCHAR(80),
  "web" VARCHAR(50)
);

CREATE TABLE "Cliente" (
  "rut" VARCHAR(10),
  "nombre" VARCHAR(120),
  "correo" VARCHAR(80),
  "direccion" VARCHAR(120),
  "celular" VARCHAR(15),
  "alta" BIT(1)
);

CREATE TABLE "Tipo_Vehiculo" (
  "id_tipo_vahiculo" INT PRIMARY KEY,
  "nombre" VARCHAR(120)
);

CREATE TABLE "Venta" (
  "folio" INT PRIMARY KEY,
  "fecha" DATE,
  "monto" INT,
  "vehiculo_id_vehiculo" INT,
  "cliente_rut" VARCHAR(10)
);

CREATE TABLE "Vehiculo" (
  "id_vehiculo" INT PRIMARY KEY,
  "patente" VARCHAR(10),
  "marca" VARCHAR(20),
  "modelo" VARCHAR(20),
  "color" VARCHAR(15),
  "precio" INT,
  "frecuencia_mantencion" INT
  "marca_id_marca" INT,
  "tipo_vehiculo_id_tipo_vehiculo" INT
);

CREATE TABLE "Mantencion" (
  "id_mantencion" INT PRIMARY KEY,
  "fecha" DATE,
  "trabajos_realizados" VARCHAR(1000),
  "venta_folio" INT
);

CREATE TABLE "Marca" (
  "id_marca" INT PRIMARY KEY,
  "nombre" VARCHAR(120)
);

ALTER TABLE "Venta" ADD FOREIGN KEY ("cliente_rut") REFERENCES "Cliente" ("rut");

ALTER TABLE "Vehiculo" ADD FOREIGN KEY ("id_vehiculo") REFERENCES "Venta" ("vehiculo_id_vehiculo");

ALTER TABLE "Vehiculo" ADD FOREIGN KEY ("tipo_vehiculo_id_tipo_vehiculo") REFERENCES "Tipo_Vehiculo" ("id_tipo_vahiculo");

ALTER TABLE "Vehiculo" ADD FOREIGN KEY ("marca_id_marca") REFERENCES "Marca" ("id_marca");

ALTER TABLE "Mantencion" ADD FOREIGN KEY ("venta_folio") REFERENCES "Venta" ("folio");
