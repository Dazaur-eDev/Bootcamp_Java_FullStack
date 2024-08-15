CREATE TABLE "Cliente" (
  "rut" VARCHAR(15) PRIMARY KEY,
  "nombre" VARCHAR(50) NOT NULL,
  "correo" VARCHAR(25) NOT NULL,
  "direccion" VARCHAR(120),
  "celular" VARCHAR(15),
  "estado_cliente" BIT NOT NULL,
  "tipo_cliente_id" VARCHAR(10) NOT NULL,
  "web" VARCHAR(100),
  "historial_mantencion" INT
);

CREATE TABLE "Tipo_Cliente" (
  "id_tipo_cliente" SERIAL PRIMARY KEY,
  "descripcion" VARCHAR(30) NOT NULL
);

CREATE TABLE "Proceso_Mantencion" (
  "id_folio" SERIAL PRIMARY KEY,
  "ejecutor_id" INT NOT NULL,
  "repuesto_id" INT NOT NULL,
  "cantidad_utilzada_repuesto" INT NOT NULL,
  "tipo_Mantencion_id" INT NOT NULL,
  "fecha" TIMESTAMP DEFAULT (NOW()),
  "km_actual" INT NOT NULL,
  "km_prox_mantencion" INT NOT NULL,
  "km_ult_mantencion" INT NOT NULL,
  "fecha_ult_mantencion" DATE NOT NULL,
  "fecha_prox_mantencion" DATE NOT NULL
);

CREATE TABLE "Tipo_Mantencion" (
  "id_tipo_mantencion" SERIAL PRIMARY KEY,
  "descripcion" VARCHAR(30) NOT NULL
);

CREATE TABLE "Respuestos" (
  "id_repuesto" SERIAL PRIMARY KEY,
  "descripcion" VARCHAR(80) NOT NULL
);

CREATE TABLE "Ejecutores" (
  "id_Ejecutor" SERIAL PRIMARY KEY,
  "alias_Ejecutor" VARCHAR(50) NOT NULL
);

CREATE TABLE "Venta" (
  "folio_venta" SERIAL PRIMARY KEY,
  "fecha" TIMESTAMP DEFAULT (NOW()),
  "monto" INT NOT NULL,
  "metodo_pago_id" INT NOT NULL,
  "patente_id" VARCHAR(15) NOT NULL,
  "cliente_id" INT NOT NULL
);

CREATE TABLE "Pagos" (
  "id_pago" SERIAL PRIMARY KEY,
  "tipo" VARCHAR(50) NOT NULL
);

CREATE TABLE "Vehiculo" (
  "patente" VARCHAR(15) PRIMARY KEY,
  "marca_id" VARCHAR NOT NULL,
  "modelo" VARCHAR(25) NOT NULL,
  "color" VARCHAR(15) NOT NULL,
  "frecuencia_km_mantencion" INT NOT NULL,
  "descripcion" VARCHAR(200),
  "tipo_vehiculo" VARCHAR(100) NOT NULL,
  "precio_id" INT NOT NULL
);

CREATE TABLE "Marca" (
  "id_marca" SERIAL PRIMARY KEY,
  "nombre" VARCHAR(50) NOT NULL
);

ALTER TABLE "Vehiculo" ADD FOREIGN KEY ("marca_id") REFERENCES "Marca" ("id_marca");

ALTER TABLE "Proceso_Mantencion" ADD FOREIGN KEY ("ejecutor_id") REFERENCES "Ejecutores" ("id_Ejecutor");

ALTER TABLE "Proceso_Mantencion" ADD FOREIGN KEY ("repuesto_id") REFERENCES "Respuestos" ("id_repuesto");

ALTER TABLE "Proceso_Mantencion" ADD FOREIGN KEY ("tipo_Mantencion_id") REFERENCES "Tipo_Mantencion" ("id_tipo_mantencion");

ALTER TABLE "Venta" ADD FOREIGN KEY ("patente_id") REFERENCES "Vehiculo" ("patente");

ALTER TABLE "Cliente" ADD FOREIGN KEY ("tipo_cliente_id") REFERENCES "Tipo_Cliente" ("id_tipo_cliente");

ALTER TABLE "Venta" ADD FOREIGN KEY ("cliente_id") REFERENCES "Cliente" ("rut");

ALTER TABLE "Pagos" ADD FOREIGN KEY ("id_pago") REFERENCES "Venta" ("metodo_pago_id");

ALTER TABLE "Proceso_Mantencion" ADD FOREIGN KEY ("id_folio") REFERENCES "Cliente" ("historial_mantencion");
