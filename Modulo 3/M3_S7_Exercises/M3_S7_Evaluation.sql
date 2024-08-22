--____________________________________________________________________________
-- Proceso creacion de tablas y referencias

CREATE TABLE "Empresa" (
  "rut" TEXT PRIMARY KEY,
  "nombre" TEXT,
  "direccion" TEXT,
  "telefono" TEXT,
  "correo" TEXT,
  "web" TEXT
);

CREATE TABLE "Herramientas" (
  "id_herramienta" SERIAL PRIMARY KEY,
  "nombre" TEXT,
  "precio_dia" INT
);

CREATE TABLE "Clientes" (
  "rut" TEXT PRIMARY KEY,
  "nombre" TEXT,
  "correo" TEXT,
  "direccion" TEXT,
  "celular" TEXT
);

CREATE TABLE "Arriendo" (
  "folio" SERIAL PRIMARY KEY,
  "fecha" date,
  "dias" INT,
  "valor_dia" INT,
  "garantia" TEXT,
  "herramienta_id_herramienta" SERIAL,
  "cliente_rut" TEXT,
  FOREIGN KEY ("cliente_rut") REFERENCES "Clientes" ("rut"),
  FOREIGN KEY ("herramienta_id_herramienta") REFERENCES "Herramientas" ("id_herramienta")
);
-- ______________________________________________________________________________________________________________________________
-- Proceso insercion de datos

INSERT INTO Empresa VALUES ('17.656.624-8', 'Orn el ferretero', 'Avenida #123', '123456789', 'ferretero@orn.com', 'ornferretero.com');

INSERT INTO Herramientas VALUES('1', 'Martillo', 1000), ('2', 'Pala', 2000), ('3', 'Llave inglesa', 5000), ('4', 'Destornillador', 1500), ('5', 'Taladro', 3000);

INSERT INTO Clientes VALUES ('8.222.134-4', 'Daniel Urqueta', 'danielurqueta@gmail.com', 'Cobija #2299', '56977657873');
INSERT INTO Clientes VALUES ('17.656.624-8', 'Eraclito Daza', 'edaza@gmail.com', 'Cobija #2299', '56977657873');
INSERT INTO Clientes VALUES ('12.365.987-3', 'Miguel Cervantes', 'miguelito@gmail.com', 'Cobija #2299', '56977657873');

INSERT INTO Arriendo VALUES ('1', '2024-08-15', 5, '5000','30 dias', '3', '8.222.134-4');
INSERT INTO Arriendo VALUES ('2', '2024-08-16', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('3', '2024-09-08', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('4', '2024-09-09', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('5', '2024-09-10', 5, '2000','30 dias', '4', '17.656.624-8');
INSERT INTO Arriendo VALUES ('6', '2024-10-12', 5, '2000','30 dias', '3', '8.222.134-4');
-- ______________________________________________________________________________________________________________________________

-- 1. Listar los clientes sin arriendos por medio de una subconsulta.
SELECT
  Clientes.rut AS RutCliente,
  Clientes.nombre AS NombreCliente
FROM
  Clientes
WHERE
  Clientes.rut NOT IN(SELECT Arriendo.cliente_rut FROM Arriendo);
-- 2. Listar todos los arriendos con las siguientes columnas: Folio, Fecha, Días, ValorDia, NombreCliente, RutCliente.
SELECT
  Arriendo.folio AS Folio,
  Arriendo.fecha AS Fecha,
  Arriendo.dias AS Dias,
  Arriendo.valor_dia AS ValorDia,
  Clientes.nombre AS NombreCliente,
  Clientes.rut AS RutCliente
FROM
  Clientes
  JOIN Arriendo ON clientes.rut = Arriendo.cliente_rut
ORDER BY
  Arriendo.folio;
-- 3. Por medio de una subconsulta listar los clientes con el nombre de la herramienta más arrendada.
SELECT
  Clientes.nombre AS NombreCliente,
  Clientes.rut AS RutCliente,
  Herramientas.nombre AS Herramienta,
  COUNT(Arriendo.herramienta_id_herramienta) AS CantidadVeces
FROM
  Clientes
  JOIN Herramientas ON Herramientas.id_herramienta = Arriendo.herramienta_id_herramienta
  JOIN Arriendo ON Clientes.rut = Arriendo.cliente_rut
WHERE
  Herramientas.id_herramienta = (
    SELECT
      Arriendo.herramienta_id_herramienta
    FROM
      Arriendo
    GROUP BY
      Arriendo.herramienta_id_herramienta
    ORDER BY
      COUNT(Arriendo.herramienta_id_herramienta) DESC
    LIMIT
      1
  )
  GROUP BY
    Clientes.nombre,
    Clientes.rut,
    Herramientas.nombre;
-- 4. Clasificar los clientes según la siguiente tabla:
-- Cantidad de arriendos mensuales entre     Clasificacion
-- 0 y 1                                       bajo
-- 2 y 3                                       medio
-- 3 o más                                     alto
SELECT
  Clientes.rut AS RutCliente,
  Clientes.nombre AS NombreCliente,
  COUNT(Arriendo.Cliente_rut) AS CantidadVeces,
  CASE
    WHEN COUNT(Arriendo.Cliente_rut) BETWEEN 0 AND 1 THEN 'bajo'
    WHEN COUNT(Arriendo.Cliente_rut) BETWEEN 2 AND 3 THEN 'medio'
    WHEN COUNT(Arriendo.Cliente_rut) > 3 THEN 'alto'
  END AS Clasificacion
FROM
  Clientes
  JOIN Arriendo ON Clientes.rut = Arriendo.cliente_rut
GROUP BY
  Clientes.rut,
  Clientes.nombre
ORDER BY
  clasificacion ASC;
