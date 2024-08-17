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

CREATE TABLE "Herramienta" (
  "id_herramienta" INT PRIMARY KEY,
  "nombre" VARCHAR(120),
  "precio_dia" INT
);

CREATE TABLE "Cliente" (
  "rut" VARCHAR(10) PRIMARY KEY,
  "nombre" VARCHAR(120),
  "correo" VARCHAR(80),
  "direccion" VARCHAR(120),
  "celular" VARCHAR(15)
);

CREATE TABLE "Arriendo" (
  "folio" INT PRIMARY KEY,
  "fecha" DATE,
  "dias" INT
  "valor_dia" INT,
  "garantia" VARCHAR(30),
  "herramienta_id_herramienta" INT,
  "cliente_rut" VARCHAR(10)
);

ALTER TABLE "Arriendo" ADD FOREIGN KEY ("cliente_rut") REFERENCES "Cliente" ("rut");

ALTER TABLE "Arriendo" ADD FOREIGN KEY ("herramienta_id_herramienta") REFERENCES "Herramienta" ("id_herramienta");
-- ______________________________________________________________________________________________________________________________

-- 1. Inserte los datos de una empresa
INSERT INTO Empresa VALUES ("17.656.624-8", "Orn el ferretero", "Avenida #123", "123456789", "ferretero@orn.com", "ornferretero.com");
-- 2. Inserte 5 herramientas
INSERT INTO Herramienta VALUES("1", "Martillo", 1000), ("2", "Pala", 2000), ("3", "Llave inglesa", 5000), ("4", "Destornillador", 1500), ("5", "Taladro", 3000);
-- 3. Inserte 3 clientes
INSERT INTO Cliente VALUES ("8.222.134-4", "Daniel Urqueta", "danielurqueta@gmail.com", "Cobija #2299", "56977657873");
INSERT INTO Cliente VALUES ("17.656.624-8", "Eraclito Daza", "edaza@gmail.com", "Cobija #2299", "56977657873");
INSERT INTO Cliente VALUES ("12.365.987-3", "Miguel Cervantes", "miguelito@gmail.com", "Cobija #2299", "56977657873");
-- 4. Elimina el último cliente
DELETE FROM Cliente WHERE rut = "12.365.987-3";
DELETE FROM Cliente WHERE rut = (SELECT rut FROM Cliente LIMIT 1 OFFSET -(SELECT COUNT(rut) - 1 FROM Cliente));
-- 5. Elimina la primera herramienta
DELETE FROM Herramienta WHERE id_herramienta = "1";
DELETE FROM Herramienta WHERE id_Herramienta = (SELECT MIN(id_herramienta) FROM Herramienta);
-- 6. Inserte 2 arriendos para cada cliente 
INSERT INTO Arriendo VALUES ("1", "2022-01-01", 5, "30 dias", "3", "8.222.134-4");
INSERT INTO Arriendo VALUES ("2", "2022-01-01", 5, "30 dias", "4", "17.656.624-8");
-- 7. Modifique el correo electrónico del primer cliente
UPDATE Cliente SET correo = "correo2modificado@gmail.com" WHERE rut = "8.222.134-4";
-- 8. Liste todas las herramientas
SELECT nombre AS Herramientas FROM Herramienta;


