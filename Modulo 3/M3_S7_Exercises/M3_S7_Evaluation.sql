--____________________________________________________________________________
-- Proceso creacion de tablas y referencias

CREATE TABLE 'Empresa' (
  'rut' VARCHAR(10) PRIMARY KEY,
  'nombre' VARCHAR(120),
  'direccion' VARCHAR(120),
  'telefono' VARCHAR(15),
  'correo' VARCHAR(80),
  'web' VARCHAR(50)
);

CREATE TABLE 'Herramientas' (
  'id_herramienta' INT PRIMARY KEY,
  'nombre' VARCHAR(120),
  'precio_dia' INT
);

CREATE TABLE 'Clientes' (
  'rut' VARCHAR(10) PRIMARY KEY,
  'nombre' VARCHAR(120),
  'correo' VARCHAR(80),
  'direccion' VARCHAR(120),
  'celular' VARCHAR(15)
);

CREATE TABLE 'Arriendo' (
  'folio' INT PRIMARY KEY,
  'fecha' DATE,
  'dias' INT,
  'valor_dia' INT,
  'garantia' VARCHAR(30),
  'herramienta_id_herramienta' INT,
  'cliente_rut' VARCHAR(10)
);

ALTER TABLE 'Arriendo' ADD FOREIGN KEY ('cliente_rut') REFERENCES 'Cliente' ('rut');

ALTER TABLE 'Arriendo' ADD FOREIGN KEY ('herramienta_id_herramienta') REFERENCES 'Herramienta' ('id_herramienta');
-- ______________________________________________________________________________________________________________________________
-- Proceso insercion de datos

INSERT INTO Empresa VALUES ('17.656.624-8', 'Orn el ferretero', 'Avenida #123', '123456789', 'ferretero@orn.com', 'ornferretero.com');

INSERT INTO Herramienta VALUES('1', 'Martillo', 1000), ('2', 'Pala', 2000), ('3', 'Llave inglesa', 5000), ('4', 'Destornillador', 1500), ('5', 'Taladro', 3000);

INSERT INTO Cliente VALUES ('8.222.134-4', 'Daniel Urqueta', 'danielurqueta@gmail.com', 'Cobija #2299', '56977657873');
INSERT INTO Cliente VALUES ('17.656.624-8', 'Eraclito Daza', 'edaza@gmail.com', 'Cobija #2299', '56977657873');
INSERT INTO Cliente VALUES ('12.365.987-3', 'Miguel Cervantes', 'miguelito@gmail.com', 'Cobija #2299', '56977657873');

INSERT INTO Arriendo VALUES ('1', '2024-08-15', 5, '5000','30 dias', '3', '8.222.134-4');
INSERT INTO Arriendo VALUES ('2', '2024-08-16', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('3', '2024-09-08', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('4', '2024-09-09', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('5', '2024-09-10', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('6', '2024-10-12', 5, '2000','30 dias', '3', '8.222.134-4');
-- ______________________________________________________________________________________________________________________________

-- 1. Listar los clientes sin arriendos por medio de una subconsulta.
-- 2. Listar todos arriendos con las siguientes columnas: Folio, Fecha, Días, ValorDia, 
-- NombreCliente, RutCliente. 
-- 3. Por medio de una subconsulta listar los clientes con el nombre de la herramienta más 
-- arrendada.
-- 4. Clasificar los clientes según la siguiente tabla:
-- Cantidad de arriendos mensuales entre     Clasificacion
-- 0 y 1                                       bajo
-- 1 y 3                                       medio
-- 3 o más                                     alto