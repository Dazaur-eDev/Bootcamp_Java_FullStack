--____________________________________________________________________________
-- Proceso creacion de tablas y referencias

CREATE TABLE Empresa (
  rut VARCHAR(12) PRIMARY KEY,
  nombre VARCHAR(120),
  direccion VARCHAR(120),
  telefono VARCHAR(15),
  correo VARCHAR(80),
  web VARCHAR(50)
);

CREATE TABLE Clientes (
  rut VARCHAR(12) PRIMARY KEY,
  nombre VARCHAR(120),
  correo VARCHAR(80),
  direccion VARCHAR(120),
  celular VARCHAR(15),
  alta BIT(1)
);

CREATE TABLE Tipo_Vehiculo (
  id_tipo_vehiculo INT PRIMARY KEY,
  nombre VARCHAR(120)
);

CREATE TABLE Marca (
  id_marca INT PRIMARY KEY,
  nombre VARCHAR(120)
);

CREATE TABLE Vehiculos (
  id_vehiculo INT PRIMARY KEY,
  patente VARCHAR(10),
  modelo VARCHAR(20),
  color VARCHAR(15),
  precio INT,
  frecuencia_mantencion INT,
  marca_id_marca INT,
  tipo_vehiculo_id_tipo_vehiculo INT,
  FOREIGN KEY (tipo_vehiculo_id_tipo_vehiculo) REFERENCES Tipo_Vehiculo (id_tipo_vehiculo),
  FOREIGN KEY (marca_id_marca) REFERENCES Marca (id_marca)
);

CREATE TABLE Venta (
  folio INT PRIMARY KEY,
  fecha DATE,
  monto INT,
  vehiculo_id_vehiculo INT,
  cliente_rut VARCHAR(12),
  FOREIGN KEY (cliente_rut) REFERENCES Clientes (rut)
);

CREATE TABLE Mantencion (
  id_mantencion INT PRIMARY KEY,
  fecha DATE,
  trabajos_realizados VARCHAR(1000),
  venta_folio INT,
  FOREIGN KEY (venta_folio) REFERENCES Venta (folio)
);
-- ______________________________________________________________________________________________________________________________
-- Proceso insercion de datos

INSERT INTO Empresa VALUES ('17.656.624-8', 'DzCompany', 'Calama #1234', '+56912345678', 'dazaur@gmail.com', 'www.dz.com');

INSERT INTO Tipo_Vehiculo VALUES (1, 'Sedan');
INSERT INTO Tipo_Vehiculo VALUES (2, '4x4');
INSERT INTO Tipo_Vehiculo VALUES (3, 'Suv');
INSERT INTO Tipo_Vehiculo VALUES (4, 'Sport');

INSERT INTO Clientes VALUES ('8.222.134-4', 'Ruth Urqueta', 'ruthcheril1958@gmail.com', 'Calama #1234', '+56912345678', 1);  
INSERT INTO Clientes VALUES ('15.825.805-6', 'Alejandro Daza', 'alejandrodaza@gmail.com', 'Calama #1234', '+56912345678', 1);
INSERT INTO Clientes VALUES ('8.985.825-6', 'Alejandro Daza', 'asdam@gmail.com', 'Calama #1234', '+56912345678', 0);
INSERT INTO Clientes VALUES ('2.985.825-K', 'Usuario 4', 'asdam4@gmail.com', 'Calama #12345', '+56912345678', 1);

INSERT INTO Marca VALUES (1, 'Toyota');
INSERT INTO Marca VALUES (2, 'Kia');
INSERT INTO Marca VALUES (3, 'Nissan');
INSERT INTO Marca VALUES (4, 'Mazda');

INSERT INTO Vehiculos VALUES (1, 'SF6635', 'Tercel', 'Verde Mica', 2000000, 5, 1, 1);
INSERT INTO Vehiculos VALUES (2, 'SF6636', 'Rx-8', 'Gris', 10000000, 5, 4, 4);
INSERT INTO Vehiculos VALUES (3, 'SF6637', 'RIO', 'Blanco', 3000000, 5, 2, 3);
INSERT INTO Vehiculos VALUES (4, 'SF6638', 'V16', 'Negro', 1000000, 5, 3, 1);
INSERT INTO Vehiculos VALUES (5, 'SF6639', 'Hilux', 'Rojo', 8000000, 5, 1, 2);
INSERT INTO Vehiculos VALUES (6, 'SF6640', 'Hilux', 'Rojo', 8000000, 5, 1, 2);
INSERT INTO Vehiculos VALUES (7, 'SF6641', 'Hilux', 'Rojo', 8000000, 5, 1, 2);
INSERT INTO Vehiculos VALUES (8, 'SF6642', 'Hilux', 'Rojo', 8000000, 5, 1, 2);

INSERT INTO Venta VALUES (1, '2022-08-15', 2000000, 1, '8.222.134-4');
INSERT INTO Venta VALUES (2, '2024-08-16', 10000000, 2, '15.825.805-6');
INSERT INTO Venta VALUES (3, '2020-08-16', 8000000, 4, '8.222.134-4');
INSERT INTO Venta VALUES (4, '2020-01-19', 1000000, 5, '8.985.825-6');
INSERT INTO Venta VALUES (5, '2020-01-19', 1000000, 6, '8.985.825-6');
INSERT INTO Venta VALUES (6, '2020-01-19', 1000000, 7, '8.985.825-6');
INSERT INTO Venta VALUES (7, '2020-01-19', 1000000, 8, '8.985.825-6');
-- ______________________________________________________________________________________________________________________________

-- 1. Listar los clientes sin ventas por medio de una subconsulta.
SELECT 
  Clientes.rut AS RutCliente,
  Clientes.nombre AS NombreCliente
FROM "Clientes"
WHERE Clientes.rut NOT IN (SELECT Venta.cliente_rut FROM "Venta");
-- 2. Listar todas las ventas con las siguientes columnas: Folio, Fecha, Monto, NombreCliente, RutCliente.
SELECT 
  Venta.folio AS Folio,
  Venta.fecha AS FechaVenta,
  Venta.monto AS MontoVenta,
  Clientes.nombre AS NombreCliente,
  Clientes.rut AS RutCliente
FROM Venta
JOIN Clientes ON Clientes.rut = Venta.cliente_rut;
-- 3. Por medio de una subconsulta listar las ventas con la marca del vehículo más vendido
SELECT
  Venta.folio AS Folio,
  Marca.nombre AS Marca,
  COUNT(Venta.vehiculo_id_vehiculo) as Count
FROM 
	Venta
	JOIN Marca ON Vehiculos.marca_id_marca = Marca.id_marca
	JOIN Vehiculos ON Vehiculos.id_vehiculo = Venta.vehiculo_id_vehiculo
WHERE
  Marca.id_marca = (
    SELECT 
      marca_id_marca
    FROM 
      Vehiculos 
    GROUP BY Marca.marca_id_marca
    ORDER BY COUNT(Marca.marca_id_marca) DESC;
    LIMIT 1
    )
  LIMIT 5;

-- 4. Clasificar los clientes según la siguiente tabla:
--   Total de ventas anuales entre     Clasificacion
--   0 a 1.000.000                      Standard
--   1.000.001 a 3.000.000              Gold
--   3.000.001 o más                    Premium
SELECT 
  Clientes.rut AS ClienteRut,
  Clientes.nombre AS NombreCliente,
  SUM(Venta.monto) AS MontoTotal,
  CASE 
    WHEN SUM(Venta.monto) BETWEEN 0 AND 1000000 THEN 'Standard'
    WHEN SUM(Venta.monto) BETWEEN 1000001 AND 30000000 THEN 'Gold'
    WHEN SUM(Venta.monto) > 30000000 THEN 'Premium'
  END AS clasificacion
FROM 
  Clientes
  JOIN Venta ON Clientes.rut = Venta.cliente_rut
GROUP BY 
  Clientes.rut,
  Clientes.nombre
ORDER BY 
  clasificacion ASC;