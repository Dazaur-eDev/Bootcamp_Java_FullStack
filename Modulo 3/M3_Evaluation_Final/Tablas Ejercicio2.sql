
-- FINAL DRILLING Modulo 3 Bases Datos
-- Ejercicio Numero 2
-- ______________________________________________________________________________________
-- //Comandos exportados de dbDiagram para postgress

CREATE TABLE "Empresa" (
  "rut" VARCHAR(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL
);

CREATE TABLE "PlantaProd" (
  "id" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL,
  "id_maquinaria" SERIAL NOT NULL
);

CREATE TABLE "Maquinaria" (
  "id" SERIAL PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL
);

CREATE TABLE "Produccion" (
  "id" NUMBER(12) PRIMARY KEY,
  "fechaInicio" DATE NOT NULL,
  "fechaTermino" DATE,
  "id_PlantaProd" NUMBER(12) NOT NULL
);

CREATE TABLE "Bodega" (
  "id" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL
);

CREATE TABLE "DetProduccion" (
  "id" NUMBER(12) PRIMARY KEY,
  "cantidadEsperada" NUMBER(12) NOT NULL,
  "cantidadObtenida" NUMBER(12),
  "fechaInicio" DATE NOT NULL,
  "fechaTermino" DATE,
  "id_receta" NUMBER(12) NOT NULL,
  "id_bodega" NUMBER(12) NOT NULL,
  "id_produccion" NUMBER(12) NOT NULL
);

CREATE TABLE "Receta" (
  "id" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL
);

CREATE TABLE "DetReceta" (
  "id_receta" NUMBER(12) NOT NULL,
  "cantidad" NUMBER(8) NOT NULL,
  "id_inventario" NUMBER(12) NOT NULL,
  "id_cecina" NUMBER(12) NOT NULL
);

CREATE TABLE "Inventario" (
  "id" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL,
  "stock" NUMBER(8) NOT NULL
);

CREATE TABLE "Cecina" (
  "id" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL,
  "stock" NUMBER(8) NOT NULL,
  "precio" NUMBER(12) NOT NULL,
  "id_tipoCecina" NUMBER(12) NOT NULL
);

CREATE TABLE "TipoCecina" (
  "id" NUMBER(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL
);

CREATE TABLE "DetCompra" (
  "id" NUMBER(12) PRIMARY KEY,
  "cantidad" NUMBER(8) NOT NULL,
  "descripcion" VARCHAR(120) NOT NULL,
  "unitario" NUMBER(12) NOT NULL,
  "id_inventario" NUMBER(12) NOT NULL,
  "id_compra_numeroFactura" NUMBER(12) NOT NULL
);

CREATE TABLE "Compra" (
  "compra_numeroFactura" NUMBER(12) PRIMARY KEY,
  "fecha" DATE NOT NULL,
  "total" NUMBER(12) NOT NULL,
  "id_proveedor" VARCHAR(12) NOT NULL
);

CREATE TABLE "Proveedor" (
  "rut" VARCHAR(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL
);

CREATE TABLE "Venta" (
  "venta_numeroFactura" NUMBER(12) PRIMARY KEY,
  "fechaVenta" DATE NOT NULL,
  "total" NUMBER(12) NOT NULL,
  "id_cliente" VARCHAR(12) NOT NULL
);

CREATE TABLE "DetVenta" (
  "id" NUMBER(12) PRIMARY KEY,
  "cantidad" NUMBER(8) NOT NULL,
  "descripcion" VARCHAR(120) NOT NULL,
  "unitario" NUMBER(12) NOT NULL,
  "id_cecina" NUMBER(12) NOT NULL,
  "id_venta_numeroFactura" NUMBER(12) NOT NULL
);

CREATE TABLE "Cliente" (
  "rut" VARCHAR(12) PRIMARY KEY,
  "nombre" VARCHAR(120) NOT NULL,
  "giro" VARCHAR(120) NOT NULL,
  "direccion" VARCHAR(120) NOT NULL,
  "ciudad" VARCHAR(40) NOT NULL,
  "fono" VARCHAR(15) NOT NULL
);

ALTER TABLE "PlantaProd" ADD PRIMARY KEY ("id_maquinaria") REFERENCES "Maquinaria" ("id");

ALTER TABLE "Produccion" ADD PRIMARY KEY ("id_PlantaProd") REFERENCES "PlantaProd" ("id");

ALTER TABLE "DetProduccion" ADD PRIMARY KEY ("id_produccion") REFERENCES "Produccion" ("id");

ALTER TABLE "DetProduccion" ADD PRIMARY KEY ("id_receta") REFERENCES "Receta" ("id");

ALTER TABLE "DetProduccion" ADD PRIMARY KEY ("id_bodega") REFERENCES "Bodega" ("id");

ALTER TABLE "DetReceta" ADD PRIMARY KEY ("id_receta") REFERENCES "Receta" ("id");

ALTER TABLE "DetReceta" ADD PRIMARY KEY ("id_inventario") REFERENCES "Inventario" ("id");

ALTER TABLE "DetReceta" ADD PRIMARY KEY ("id_cecina") REFERENCES "Cecina" ("id");

ALTER TABLE "Cecina" ADD PRIMARY KEY ("id_tipoCecina") REFERENCES "TipoCecina" ("id");

ALTER TABLE "Compra" ADD PRIMARY KEY ("id_proveedor") REFERENCES "Proveedor" ("rut");

ALTER TABLE "DetCompra" ADD PRIMARY KEY ("id_compra_numeroFactura") REFERENCES "Compra" ("compra_numeroFactura");

ALTER TABLE "DetCompra" ADD PRIMARY KEY ("id_inventario") REFERENCES "Inventario" ("id");

ALTER TABLE "DetVenta" ADD PRIMARY KEY ("id_venta_numeroFactura") REFERENCES "Venta" ("venta_numeroFactura");

ALTER TABLE "DetVenta" ADD PRIMARY KEY ("id_cecina") REFERENCES "Cecina" ("id");

ALTER TABLE "Venta" ADD PRIMARY KEY ("id_cliente") REFERENCES "Cliente" ("rut");

--____________________________________________________________________________________
-- Comandos usados en postgress

CREATE TABLE empresa (
  rut TEXT PRIMARY KEY, 
  nombre TEXT NOT NULL
);

CREATE TABLE maquinaria (
  id BIGINT PRIMARY KEY generated always as identity,
  nombre TEXT NOT NULL
);

CREATE TABLE tipocecina (
  id BIGINT PRIMARY KEY generated always as identity,
  nombre TEXT NOT NULL
);

CREATE TABLE plantaprod (
  id BIGINT PRIMARY KEY generated always as identity,
  nombre TEXT NOT NULL,
  id_maquinaria BIGINT NOT NULL REFERENCES maquinaria (id)
);

CREATE TABLE produccion (
  id BIGINT PRIMARY KEY generated always as identity,
  fechainicio DATE NOT NULL,
  fechatermino DATE,
  id_plantaprod BIGINT NOT NULL REFERENCES plantaprod (id)
);

CREATE TABLE bodega (
  id BIGINT PRIMARY KEY generated always as identity,
  nombre TEXT NOT NULL
);

CREATE TABLE receta (
  id BIGINT PRIMARY KEY generated always as identity,
  nombre TEXT NOT NULL
);

CREATE TABLE inventario (
  id BIGINT PRIMARY KEY generated always as identity,
  nombre TEXT NOT NULL,
  stock BIGINT NOT NULL
);

CREATE TABLE cecina (
  id BIGINT PRIMARY KEY generated always as identity,
  nombre TEXT NOT NULL,
  stock BIGINT NOT NULL,
  precio BIGINT NOT NULL,
  id_tipocecina BIGINT NOT NULL REFERENCES tipocecina (id)
);

CREATE TABLE proveedor (
  rut TEXT PRIMARY KEY,
  nombre TEXT NOT NULL
);

CREATE TABLE cliente (
  rut TEXT PRIMARY KEY,
  nombre TEXT NOT NULL,
  giro TEXT NOT NULL,
  direccion TEXT NOT NULL,
  ciudad TEXT NOT NULL,
  fono TEXT NOT NULL
);

CREATE TABLE compra (
  compra_numerofactura BIGINT PRIMARY KEY generated always as identity,
  fecha DATE NOT NULL,
  total BIGINT NOT NULL,
  id_proveedor TEXT NOT NULL REFERENCES proveedor (rut)
);

CREATE TABLE venta (
  venta_numerofactura BIGINT PRIMARY KEY generated always as identity,
  fechaventa DATE NOT NULL,
  total BIGINT NOT NULL,
  id_cliente TEXT NOT NULL REFERENCES cliente (rut)
);

CREATE TABLE detproduccion (
  id BIGINT PRIMARY KEY generated always as identity,
  cantidadesperada BIGINT NOT NULL,
  cantidadobtenida BIGINT,
  fechainicio DATE NOT NULL,
  fechatermino DATE,
  id_receta BIGINT NOT NULL REFERENCES receta (id),
  id_bodega BIGINT NOT NULL REFERENCES bodega (id),
  id_produccion BIGINT NOT NULL REFERENCES produccion (id)
);

CREATE TABLE detreceta (
  id_receta BIGINT NOT NULL REFERENCES receta (id),
  cantidad BIGINT NOT NULL,
  id_inventario BIGINT NOT NULL REFERENCES inventario (id),
  id_cecina BIGINT NOT NULL REFERENCES cecina (id)
);

CREATE TABLE detcompra (
  id BIGINT PRIMARY KEY generated always as identity,
  cantidad BIGINT NOT NULL,
  descripcion TEXT NOT NULL,
  unitario BIGINT NOT NULL,
  id_inventario BIGINT NOT NULL REFERENCES inventario (id),
  id_compra_numerofactura BIGINT NOT NULL REFERENCES compra (compra_numerofactura)
);

CREATE TABLE detventa (
  id BIGINT PRIMARY KEY generated always as identity,
  cantidad BIGINT NOT NULL,
  descripcion TEXT NOT NULL,
  unitario BIGINT NOT NULL,
  id_cecina BIGINT NOT NULL REFERENCES cecina (id),
  id_venta_numerofactura BIGINT NOT NULL REFERENCES venta (venta_numerofactura)
);
