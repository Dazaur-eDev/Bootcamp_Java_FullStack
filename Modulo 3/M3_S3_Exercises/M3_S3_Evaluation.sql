CREATE TABLE "Departamentos" (
  "id_departamento" SERIAL PRIMARY KEY,
  "nombre_departamento" VARCHAR(100) NOT NULL,
  "jefe_id" INT UNIQUE NOT NULL
);

CREATE TABLE "Proyectos" (
  "id_proyecto" SERIAL PRIMARY KEY,
  "nombre_proyecto" VARCHAR(100) NOT NULL,
  "departamento_id" INT NOT NULL
);

CREATE TABLE "Empleados" (
  "id_empleado" SERIAL PRIMARY KEY,
  "nombre_empleado" VARCHAR(50) NOT NULL,
  "departamento_id" INT NOT NULL
);

CREATE TABLE "Jefes" (
  "id_jefe" SERIAL PRIMARY KEY,
  "nombre_jefe" VARCHAR(50) NOT NULL
);

CREATE TABLE "Empleado_Proyecto" (
  "proyecto_id" INT NOT NULL,
  "empleado_id" INT NOT NULL
);

ALTER TABLE "Proyectos" ADD FOREIGN KEY ("departamento_id") REFERENCES "Departamentos" ("id_departamento");

ALTER TABLE "Empleados" ADD FOREIGN KEY ("departamento_id") REFERENCES "Departamentos" ("id_departamento");

ALTER TABLE "Empleado_Proyecto" ADD FOREIGN KEY ("empleado_id") REFERENCES "Empleados" ("id_empleado");

ALTER TABLE "Empleado_Proyecto" ADD FOREIGN KEY ("proyecto_id") REFERENCES "Proyectos" ("id_proyecto");

ALTER TABLE "Departamentos" ADD FOREIGN KEY ("jefe_id") REFERENCES "Jefes" ("id_jefe");
