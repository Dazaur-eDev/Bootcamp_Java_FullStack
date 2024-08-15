CREATE TABLE "Clientes" (
  "rut" VARCHAR(15) PRIMARY KEY,
  "nombre" VARCHAR(100) NOT NULL,
  "email" VARCHAR(50) NOT NULL,
  "direccion" VARCHAR(100),
  "celular" VARCHAR(25) NOT NULL,
  "id_estado_cliente" INT NOT NULL,
  "fecha_creacion" DATETIME DEFAULT (NOW())
);

CREATE TABLE "Listado_Estado_Cliente" (
  "id_estado_cliente" SERIAL PRIMARY KEY,
  "descripcion_estado" VARCHAR(25)
);

CREATE TABLE "Herramientas" (
  "id_herramienta" SERIAL PRIMARY KEY,
  "id_categoria" INT,
  "marca" VARCHAR(20) NOT NULL,
  "modelo" VARCHAR(30) NOT NULL,
  "color" VARCHAR(20) NOT NULL,
  "precio_arriendo" INT,
  "fecha_adquisicion" DATETIME
);

CREATE TABLE "Listado_Categoria_Herramienta" (
  "id_categoria" SERIAL PRIMARY KEY,
  "descripcion_cat" VARCHAR(50) NOT NULL
);

CREATE TABLE "Listado_Garantias_Arriendo" (
  "id_garantia" SERIAL PRIMARY KEY,
  "descripcion_garantia" VARCHAR(20) NOT NULL
);

CREATE TABLE "Detalle_Arriendo" (
  "id_folio" SERIAL PRIMARY KEY,
  "id_cliente" INT NOT NULL,
  "id_garantia" INT NOT NULL,
  "id_estado_arriendo" INT NOT NULL,
  "fecha_arriendo" DATETIME NOT NULL,
  "fecha_finalizacion_arriendo" DATETIME NOT NULL
);

CREATE TABLE "Listado_Estado_Arriendo" (
  "id_estado_arriendo" SERIAL PRIMARY KEY,
  "descripcion" VARCHAR(20) NOT NULL
);

CREATE TABLE "Detalle_Arriendo_Herramientas" (
  "id_carro" SERIAL PRIMARY KEY,
  "id_folio" INT NOT NULL,
  "id_herramienta" INT NOT NULL
);

ALTER TABLE "Detalle_Arriendo_Herramientas" ADD FOREIGN KEY ("id_herramienta") REFERENCES "Herramientas" ("id_herramienta");

ALTER TABLE "Detalle_Arriendo" ADD FOREIGN KEY ("id_cliente") REFERENCES "Clientes" ("rut");

ALTER TABLE "Detalle_Arriendo" ADD FOREIGN KEY ("id_garantia") REFERENCES "Listado_Garantias_Arriendo" ("id_garantia");

ALTER TABLE "Clientes" ADD FOREIGN KEY ("id_estado_cliente") REFERENCES "Listado_Estado_Cliente" ("id_estado_cliente");

ALTER TABLE "Detalle_Arriendo" ADD FOREIGN KEY ("id_estado_arriendo") REFERENCES "Listado_Estado_Arriendo" ("id_estado_arriendo");

ALTER TABLE "Detalle_Arriendo_Herramientas" ADD FOREIGN KEY ("id_folio") REFERENCES "Detalle_Arriendo" ("id_folio");

ALTER TABLE "Herramientas" ADD FOREIGN KEY ("id_categoria") REFERENCES "Listado_Categoria_Herramienta" ("id_categoria");
