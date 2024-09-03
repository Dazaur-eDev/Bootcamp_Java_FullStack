//____________________________________________________________________________________
//Comandos exportados de dbDiagram para postgress

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

ALTER TABLE "PlantaProd" ADD FOREIGN KEY ("id_maquinaria") REFERENCES "Maquinaria" ("id");

ALTER TABLE "Produccion" ADD FOREIGN KEY ("id_PlantaProd") REFERENCES "PlantaProd" ("id");

ALTER TABLE "DetProduccion" ADD FOREIGN KEY ("id_produccion") REFERENCES "Produccion" ("id");

ALTER TABLE "DetProduccion" ADD FOREIGN KEY ("id_receta") REFERENCES "Receta" ("id");

ALTER TABLE "DetProduccion" ADD FOREIGN KEY ("id_bodega") REFERENCES "Bodega" ("id");

ALTER TABLE "DetReceta" ADD FOREIGN KEY ("id_receta") REFERENCES "Receta" ("id");

ALTER TABLE "DetReceta" ADD FOREIGN KEY ("id_inventario") REFERENCES "Inventario" ("id");

ALTER TABLE "DetReceta" ADD FOREIGN KEY ("id_cecina") REFERENCES "Cecina" ("id");

ALTER TABLE "Cecina" ADD FOREIGN KEY ("id_tipoCecina") REFERENCES "TipoCecina" ("id");

ALTER TABLE "Compra" ADD FOREIGN KEY ("id_proveedor") REFERENCES "Proveedor" ("rut");

ALTER TABLE "DetCompra" ADD FOREIGN KEY ("id_compra_numeroFactura") REFERENCES "Compra" ("compra_numeroFactura");

ALTER TABLE "DetCompra" ADD FOREIGN KEY ("id_inventario") REFERENCES "Inventario" ("id");

ALTER TABLE "DetVenta" ADD FOREIGN KEY ("id_venta_numeroFactura") REFERENCES "Venta" ("venta_numeroFactura");

ALTER TABLE "DetVenta" ADD FOREIGN KEY ("id_cecina") REFERENCES "Cecina" ("id");

ALTER TABLE "Venta" ADD FOREIGN KEY ("id_cliente") REFERENCES "Cliente" ("rut");

//____________________________________________________________________________________
//Comandos usados en postgress

CREATE TABLE empresa (
  rut text primary key, 
  nombre text not null
);

CREATE TABLE maquinaria (
  id bigint primary key generated always as identity,
  nombre text not null
);

CREATE TABLE tipocecina (
  id bigint primary key generated always as identity,
  nombre text not null
);

CREATE TABLE plantaprod (
  id bigint primary key generated always as identity,
  nombre text not null,
  id_maquinaria bigint not null references maquinaria (id)
);

CREATE TABLE produccion (
  id bigint primary key generated always as identity,
  fechainicio date not null,
  fechatermino date,
  id_plantaprod bigint not null references plantaprod (id)
);

CREATE TABLE bodega (
  id bigint primary key generated always as identity,
  nombre text not null
);

CREATE TABLE receta (
  id bigint primary key generated always as identity,
  nombre text not null
);

CREATE TABLE inventario (
  id bigint primary key generated always as identity,
  nombre text not null,
  stock bigint not null
);

CREATE TABLE cecina (
  id bigint primary key generated always as identity,
  nombre text not null,
  stock bigint not null,
  precio bigint not null,
  id_tipocecina bigint not null references tipocecina (id)
);

CREATE TABLE proveedor (
  rut text primary key,
  nombre text not null
);

CREATE TABLE cliente (
  rut text primary key,
  nombre text not null,
  giro text not null,
  direccion text not null,
  ciudad text not null,
  fono text not null
);

CREATE TABLE compra (
  compra_numerofactura bigint primary key generated always as identity,
  fecha date not null,
  total bigint not null,
  id_proveedor text not null references proveedor (rut)
);

CREATE TABLE venta (
  venta_numerofactura bigint primary key generated always as identity,
  fechaventa date not null,
  total bigint not null,
  id_cliente text not null references cliente (rut)
);

CREATE TABLE detproduccion (
  id bigint primary key generated always as identity,
  cantidadesperada bigint not null,
  cantidadobtenida bigint,
  fechainicio date not null,
  fechatermino date,
  id_receta bigint not null references receta (id),
  id_bodega bigint not null references bodega (id),
  id_produccion bigint not null references produccion (id)
);

CREATE TABLE detreceta (
  id_receta bigint not null references receta (id),
  cantidad bigint not null,
  id_inventario bigint not null references inventario (id),
  id_cecina bigint not null references cecina (id)
);

CREATE TABLE detcompra (
  id bigint primary key generated always as identity,
  cantidad bigint not null,
  descripcion text not null,
  unitario bigint not null,
  id_inventario bigint not null references inventario (id),
  id_compra_numerofactura bigint not null references compra (compra_numerofactura)
);

CREATE TABLE detventa (
  id bigint primary key generated always as identity,
  cantidad bigint not null,
  descripcion text not null,
  unitario bigint not null,
  id_cecina bigint not null references cecina (id),
  id_venta_numerofactura bigint not null references venta (venta_numerofactura)
);
