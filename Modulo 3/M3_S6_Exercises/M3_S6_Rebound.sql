--____________________________________________________________________________
-- Proceso creacion de tablas y referencias

CREATE TABLE "Empresa" (
  "rut" VARCHAR(12) PRIMARY KEY,
  "nombre" VARCHAR(120),
  "direccion" VARCHAR(120),
  "telefono" VARCHAR(15),
  "correo" VARCHAR(80),
  "web" VARCHAR(50)
);

CREATE TABLE "Clientes" (
  "rut" VARCHAR(12),
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

CREATE TABLE "Vehiculos" (
  "id_vehiculo" INT PRIMARY KEY,
  "patente" VARCHAR(10),
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
-- Proceso insercion de datos

INSERT INTO Empresa VALUES ("17.656.624-8", "DzCompany", "Calama #1234", "+56912345678", "dazaur@gmail.com", "www.dz.com");

INSERT INTO Tipo_Vehiculo VALUES (1, "Sedan");
INSERT INTO Tipo_Vehiculo VALUES (2, "4x4");
INSERT INTO Tipo_Vehiculo VALUES (3, "Suv");
INSERT INTO Tipo_Vehiculo VALUES (4, "Sport");

INSERT INTO Clientes VALUES ("8.222.134-4", "Ruth Urqueta", "ruthcheril1958@gmail.com", "Calama #1234", "+56912345678", 1);  
INSERT INTO Clientes VALUES ("15.825.805-6", "Alejandro Daza", "alejandrodaza@gmail.com", "Calama #1234", "+56912345678", 1);
INSERT INTO Clientes VALUES ("8.985.825-6", "Alejandro Daza", "asdam@gmail.com", "Calama #1234", "+56912345678", 0);

INSERT INTO Marca VALUES (1, "Toyota");
INSERT INTO Marca VALUES (2, "Kia");
INSERT INTO Marca VALUES (3, "Nissan");
INSERT INTO Marca VALUES (4, "Mazda");

INSERT INTO Vehiculos VALUES (1, "SF6635", "Tercel", "Verde Mica", 2000000, 5, 1, 1);
INSERT INTO Vehiculos VALUES (2, "SF6636", "Rx-8", "Gris", 10000000, 5, 4, 4);
INSERT INTO Vehiculos VALUES (3, "SF6637", "RIO", "Blanco", 3000000, 5, 2, 3);
INSERT INTO Vehiculos VALUES (4, "SF6638", "V16", "Negro", 1000000, 5, 3, 1);
INSERT INTO Vehiculos VALUES (5, "SF6639", "Hilux", "Rojo", 8000000, 5, 1, 2);

INSERT INTO Venta VALUES (1, "2022-08-15", 2000000, 1, "8.222.134-4");
INSERT INTO Venta VALUES (2, "2024-08-16", 10000000, 2, "15.825.805-6");
INSERT INTO Venta VALUES (3, "2020-08-16", 8000000, 5, "8.222.134-4");
INSERT INTO Venta VALUES (4, "2020-01-19", 1000000, 4, "8.985.825-6");
-- ______________________________________________________________________________________________________________________________

-- 1. Listar todos los vehículos que no han sido vendidos.
SELECT * FROM Vehiculos WHERE id_vehiculo NOT IN (SELECT vehiculo_id_vehiculo FROM Venta);
-- Otra forma de hacerlo
SELECT *
FROM Vehiculos
LEFT JOIN Venta ON Vehiculos.id_vehiculo = Venta.vehiculo_id_vehiculo
WHERE Venta.vehiculo_id_vehiculo IS NULL;
-- 2. Listar todas las ventas de enero del 2020 con las columnas (Folio, FechaVenta, MontoVenta, NombreCliente, RutCliente, Patente, nombre_marca, Modelo).
SELECT folio, fecha, monto, Clientes.nombre, rut, patente, Marca.nombre, modelo
FROM Venta
JOIN Vehiculos ON Vehiculos.id_vehiculo = Venta.vehiculo_id_vehiculo
JOIN Clientes ON Clientes.rut =  Venta.cliente_rut
JOIN Marca ON Vehiculos.marca_id_marca = Marca.id_marca
WHERE Venta.fecha BETWEEN '2020-01-01' AND '2020-01-31';
-- 3. Sume las ventas por mes y marca del año 2020.
SELECT 
    EXTRACT(MONTH FROM Venta.fecha) AS mes,
    Marca.nombre AS nombre_marca,
    SUM(Venta.monto) AS total_ventas
FROM "Venta"
JOIN "Vehiculos" ON Venta.vehiculo_id_vehiculo = Vehiculos.id_vehiculo
JOIN "Marca" ON Vehiculos.marca_id_marca = Marca.id_marca
WHERE EXTRACT(YEAR FROM Venta.fecha) = 2020
GROUP BY mes, nombre_marca
ORDER BY mes, nombre_marca;
-- 4. Liste Rut y Nombre de las tablas cliente y empresa.
SELECT rut, nombre FROM Clientes
UNION
SELECT rut, nombre FROM Empresa;
