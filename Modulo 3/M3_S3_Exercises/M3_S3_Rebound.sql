CREATE TABLE "Ordenes" (
  "idOrden" SERIAL PRIMARY KEY,
  "fecha" DATE DEFAULT (NOW()),
  "idCliente" VARCHAR(50) NOT NULL,
  "idCarro" INT NOT NULL
);

CREATE TABLE "Clientes" (
  "idCliente" VARCHAR(15) PRIMARY KEY,
  "nombreCliente" VARCHAR(50) NOT NULL,
  "ciudadCliente" VARCHAR(50) NOT NULL
);

CREATE TABLE "Articulos" (
  "codigo" VARCHAR(20) PRIMARY KEY,
  "nombreArticulo" VARCHAR(50) NOT NULL,
  "precio" INT NOT NULL
);

CREATE TABLE "CarroCliente" (
  "idCarro" SERIAL PRIMARY KEY,
  "idArticulo" VARCHAR(20) NOT NULL,
  "cantidad" INT NOT NULL,
  "precio" INT NOT NULL
);

ALTER TABLE "CarroCliente" ADD FOREIGN KEY ("idArticulo") REFERENCES "Articulos" ("codigo");

ALTER TABLE "CarroCliente" ADD FOREIGN KEY ("idCarro") REFERENCES "Ordenes" ("idCarro");

ALTER TABLE "Clientes" ADD FOREIGN KEY ("idCliente") REFERENCES "Ordenes" ("idCliente");
