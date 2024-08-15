CREATE TABLE "clientes" (
  "id_cliente" integer,
  "rut" nvarchar,
  "nombre" nvarchar,
  "email" nvarchar,
  "direccion" nvarchar,
  "celular" nvarchar,
  "id_estado_cliente" integer,
  "fecha_creacion" datetime,
  PRIMARY KEY ("id_cliente", "rut")
);

CREATE TABLE "estado_cliente" (
  "id_estado_cliente" integer PRIMARY KEY,
  "descripcion_estado" nvarchar
);

CREATE TABLE "herramientas" (
  "id_herramienta" integer PRIMARY KEY,
  "id_categoria" integer,
  "marca" nvarchar,
  "modelo" nvarchar,
  "color" nvarchar,
  "precio_arriendo" decimal,
  "fecha_adquisicion" datetime
);

CREATE TABLE "categoria_herramienta" (
  "id_categoria" integer PRIMARY KEY,
  "descripcion_cat" nvarchar
);

CREATE TABLE "garantias_arriendo" (
  "id_garantia" integer PRIMARY KEY,
  "descripcion_garantia" nvarchar
);

CREATE TABLE "proceso_arriendo" (
  "id_proceso_arriendo" integer PRIMARY KEY,
  "id_cliente" integer,
  "id_herramienta" integer,
  "id_garantia" integer,
  "id_estado_arriendo" integer,
  "fecha_arriendo" datetime,
  "fecha_finalizacion_arriendo" datetime
);

CREATE TABLE "estado_arriendo" (
  "id_estado_arriendo" integer PRIMARY KEY,
  "descripcion_estado_arriendo" nvarchar
);

ALTER TABLE "proceso_arriendo" ADD FOREIGN KEY ("id_cliente") REFERENCES "clientes" ("id_cliente");

ALTER TABLE "categoria_herramienta" ADD FOREIGN KEY ("id_categoria") REFERENCES "herramientas" ("id_categoria");

ALTER TABLE "proceso_arriendo" ADD FOREIGN KEY ("id_herramienta") REFERENCES "herramientas" ("id_herramienta");

ALTER TABLE "proceso_arriendo" ADD FOREIGN KEY ("id_garantia") REFERENCES "garantias_arriendo" ("id_garantia");

ALTER TABLE "proceso_arriendo" ADD FOREIGN KEY ("id_estado_arriendo") REFERENCES "estado_arriendo" ("id_estado_arriendo");

ALTER TABLE "clientes" ADD FOREIGN KEY ("id_estado_cliente") REFERENCES "estado_cliente" ("id_estado_cliente");
