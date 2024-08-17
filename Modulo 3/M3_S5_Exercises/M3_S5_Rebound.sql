--____________________________________________________________________________
-- Proceso creacion de tablas y referencias
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
  "frecuencia_mantencion" INT,
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
-- ______________________________________________________________________________________________________________________________

-- • Inserte los datos de una empresa
INSERT INTO Empresa VALUES ("17.656.624-8", "DzCompany", "Calama #1234", "+56912345678", "dazaur@gmail.com", "www.dz.com");
INSERT INTO Empresa VALUES ("17.656.624-k", "DzCompany", "Calama #1234", "+56912345678", "dazaur@gmail.com", "www.dz.com");
-- • Eliminar el rut 17.656.624-k 
DELETE FROM Empresa WHERE rut = "17.656.624-k";
-- • Inserte 2 tipos de vehículo
INSERT INTO Tipo_Vehiculo VALUES (1, "Sedan");
INSERT INTO Tipo_Vehiculo VALUES (2, "4x4");
INSERT INTO Tipo_Vehiculo VALUES (3, "Suv");
INSERT INTO Tipo_Vehiculo Values (4, "Sport");
-- • Modificar el nombre de una tabla
ALTER TABLE Cliente RENAME TO Clientes;
-- • Inserte 3 clientes
INSERT INTO Clientes VALUES ("8.222.134-4", "Ruth Urqueta", "ruthcheril1958@gmail.com", "Calama #1234", "+56912345678", 1);  
INSERT INTO Clientes VALUES ("15.825.805-6", "Alejandro Daza", "alejandrodaza@gmail.com", "Calama #1234", "+56912345678", 1);
INSERT INTO Clientes VALUES ("8.985.825-6", "Alejandro Daza", "asdam@gmail.com", "Calama #1234", "+56912345678", 0);
-- • Inserte 2 marcas
INSERT INTO Marca VALUES (1, "Toyota");
INSERT INTO Marca VALUES (2, "Kia");
INSERT INTO Marca VALUES (3, "Nissan");
INSERT INTO Marca VALUES (4, "Mazda");
-- • Inserte 5 vehículos
-- En el ejercicio, se entrega el modelo de relacion-entidad, sin embargo, en la tabla de Vehiculos, el atributo marca es redundante al tener una tabla con el id de cada Marca asociado a ella, por tanto, lo eliminaré
ALTER TABLE Vehiculo RENAME TO Vehiculos;
ALTER TABLE Vehiculos DROP COLUMN marca;
INSERT INTO Vehiculos VALUES (1, "SF6635", "Tercel", "Verde Mica", 2000000, 5, 1);
INSERT INTO Vehiculos VALUES (2, "SF6636", "Rx-8", "Gris", 10000000, 5, 4, 4);
INSERT INTO Vehiculos VALUES (3, "SF6637", "RIO", "Blanco", 3000000, 5, 2, 3);
INSERT INTO Vehiculos VALUES (4, "SF6638", "V16", "Negro", 1000000, 5, 3, 1);
INSERT INTO Vehiculos VALUES (5, "SF6639", "Hilux", "Rojo", 8000000, 5, 1, 2);
-- • Elimina el último cliente
--Opción básica y directa
DELETE FROM Clientes WHERE rut = "8.985.825-6";
-- Una alternativa mejor para eliminar el ultimo registro de la tabla
DELETE FROM Clientes WHERE rut = (
  SELECT rut FROM Clientes LIMIT 1 OFFSET (-- obtengo el valor de la rut con el offset o salto obtenido del recuento total ejecutado en la linea siguiente
    SELECT COUNT(rut) - 1 FROM Clientes); --contar el total de filas de la columna rut y restarle 1
-- • Inserte 1 venta para cada cliente
INSERT INTO Venta VALUES (1, "2022-08-15", 2000000, 1, 1);
INSERT INTO Venta VALUES (2, "2024-08-16", 10000000, 2, 2);
-- • Modifique el nombre del segundo cliente
UPDATE Clientes SET nombre = "NuevoNombre" WHERE rut = "15.825.805-6";
-- • Liste todas las ventas
SELECT * FROM Venta;
-- • Liste las ventas del primer cliente
SELECT * FROM Venta WHERE cliente_rut = "1";
SELECT * FROM Venta WHERE cliente_rut = (SELECT MIN(cliente_rut) FROM Venta);
-- • Obtenga la patente de todos los vehículos
SELECT Patente FROM Vehiculos;
