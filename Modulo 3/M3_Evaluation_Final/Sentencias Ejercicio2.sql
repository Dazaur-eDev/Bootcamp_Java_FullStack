
-- FINAL DRILLING Modulo 3 Bases Datos
-- Ejercicio Numero 2
-- SENTENCIAS EJERCICIO 2

-- Construya las siguientes consultas: 
--___________________________________________________________________________________________________________________________
-- • Construir las consultas para insertar, modificar y eliminar un Proveedor, Compra y Detalle Compra (DetCompra). 
-- (Las inserciones de datos las realizaré a medida que las vaya necesitando)
--___________________________________________________________________________________________________________________________
--INSERCIONES
-- Insertar un proveedor 
INSERT INTO proveedor VALUES ('77656624-8', 'ProovedorSur');
INSERT INTO proveedor VALUES ('77656624-9', 'ProovedorNorte');
SELECT * FROM proveedor;
-- Insertar una compra
INSERT INTO compra (fecha, total, id_proveedor) VALUES ('2024-09-06', 1000, '77656624-8');
INSERT INTO compra (fecha, total, id_proveedor) VALUES ('2024-09-06', 5000, '77656624-8');
SELECT * FROM compra;
--Insertar un detalle de venta
INSERT INTO inventario (nombre, stock) VALUES ('ingrediente1', 10);
INSERT INTO inventario (nombre, stock) VALUES ('ingrediente2', 5);
SELECT * FROM inventario;
INSERT INTO detcompra (cantidad, descripcion, unitario, id_inventario, id_compra_numerofactura) VALUES (2, 'compra de ingrediente1 por proveedorSur para asadiiiito', 500, 1, 1);
INSERT INTO detcompra (cantidad, descripcion, unitario, id_inventario, id_compra_numerofactura) VALUES (1, 'compra de ingrediente1 por proveedorSur para asadiiiito', 5000, 2, 2);
SELECT * FROM detcompra;
--___________________________________________________________________________________________________________________________
--MODIFICACIONES
-- Modificar proveedor
UPDATE proveedor SET nombre = 'ProveedorBorrar'WHERE rut = '77656624-9';
SELECT * FROM proveedor;
-- Modificar compra
UPDATE compra SET fecha = '2024-09-05' WHERE (compra_numeroFactura = 1 AND total = 1000);
SELECT * FROM compra;
-- Modificar detalle compra
UPDATE detCompra SET descripcion = 'compra de ingrediente2 para asadiiiito' WHERE id = 2;
SELECT * FROM detcompra;
--___________________________________________________________________________________________________________________________
--ELIMINACIONES
-- Eliminar proveedor
DELETE FROM proveedor WHERE rut = '77656624-9';
SELECT * FROM proveedor;
-- Eliminar detalle de compra
DELETE FROM detCompra WHERE id_compra_numeroFactura = 2;
SELECT * FROM detcompra;
-- Eliminar compra
DELETE FROM compra WHERE (fecha = '2024-09-06' AND total = 5000);
SELECT * FROM compra;
--___________________________________________________________________________________________________________________________
-- • Listar todas las compras con los datos del cliente dado un año y mes. 
-- (imagino que se refiere a ventas, porque compras son las que realiza la empresa de cecinas a los proveedores)
-- de igual forma realizaré para ambos casos
--___________________________________________________________________________________________________________________________

-- Inserciones para tener informacion en la base datos
INSERT INTO cliente (rut, nombre, giro, direccion, ciudad, fono) VALUES ('17656624-7', 'cliente1', 'giro1', 'direccion1', 'ciudad1', 'fono1');
INSERT INTO cliente (rut, nombre, giro, direccion, ciudad, fono) VALUES ('17656624-8', 'cliente2', 'giro2', 'direccion2', 'ciudad2', 'fono2');
INSERT INTO cliente (rut, nombre, giro, direccion, ciudad, fono) VALUES ('17656624-9', 'cliente3', 'giro3', 'direccion3', 'ciudad3', 'fono3');

INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2024-01-04', 1000, '17656624-7');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2024-01-05', 2000, '17656624-8');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2024-01-06', 3000, '17656624-9');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2024-09-04', 1000, '17656624-7');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2024-09-05', 2000, '17656624-8');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2024-09-06', 3000, '17656624-9');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2020-09-06', 3000, '17656624-8');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2020-09-06', 3000, '17656624-8');
INSERT INTO venta (fechaVenta, total, id_cliente) VALUES ('2020-09-06', 3000, '17656624-8');

INSERT INTO tipocecina(nombre) VALUES('tipocecina1');
INSERT INTO tipocecina(nombre) VALUES('tipocecina2');
INSERT INTO tipocecina(nombre) VALUES('tipocecina3');

INSERT INTO cecina(nombre, stock, precio , id_tipocecina) VALUES ('cecina1', 10, 1000, 1);
INSERT INTO cecina(nombre, stock, precio , id_tipocecina) VALUES ('cecina2', 10, 1000, 2);
INSERT INTO cecina(nombre, stock, precio , id_tipocecina) VALUES ('cecina3', 10, 1000, 3);

INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (2, 'detalleventa1', 500, 1, 1);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (4, 'detalleventa2', 500, 2, 2);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (6, 'detalleventa3', 500, 3, 3);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (2, 'detalleventa4', 500, 1, 4);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (4, 'detalleventa5', 500, 2, 5);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (6, 'detalleventa6', 500, 3, 6);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (6, 'detalleventa7', 500, 3, 7);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (6, 'detalleventa8', 500, 3, 8);
INSERT INTO detVenta (cantidad, descripcion, unitario, id_cecina, id_venta_numerofactura) VALUES (6, 'detalleventa9', 500, 3, 9);

-- Para el caso de ventas, considerando año 2020 y mes de mayo
SELECT 
  cliente.nombre AS NombreCliente,
  cliente.rut AS id_Cliente,
  venta.fechaventa AS Fecha,
  venta.total AS TotalMontoVenta
FROM
  venta
  JOIN cliente ON venta.id_cliente = cliente.rut
  JOIN detventa ON venta.venta_numerofactura = detventa.id_venta_numerofactura
WHERE
  EXTRACT(YEAR FROM venta.fechaventa) = 2020 AND EXTRACT(MONTH FROM venta.fechaventa) = 5;

-- para el caso de compras, considerando año 2020 y mes de septiembre
SELECT 
  proveedor.nombre AS NombreProveedor,
  proveedor.rut AS id_Proveedor,
  compra.fecha AS Fecha,
  compra.total AS TotalMontoCompra
FROM
  compra
  JOIN proveedor ON compra.id_proveedor = proveedor.rut
  JOIN detcompra ON compra.compra_numerofactura = detcompra.id_compra_numerofactura
WHERE
  EXTRACT(YEAR FROM compra.fecha) = 2020 AND EXTRACT(MONTH FROM compra.fecha) = 9;

--___________________________________________________________________________________________________________________________
-- • Listar numero, fecha y total de todas las compras y ventas
--___________________________________________________________________________________________________________________________
SELECT
  venta.venta_numerofactura AS NumeroFacturaVenta,
  venta.fechaventa AS FechaVenta,
  venta.total AS TotalVenta,
  venta.id_cliente AS Cliente,
  'venta' AS Tipo
FROM
  venta
  JOIN cliente ON cliente.rut = venta.id_cliente
UNION ALL
SELECT
  compra.compra_numerofactura AS NumeroFacturaCompra,
  compra.fecha AS Fecha,
  compra.total AS TotalCompra,
  compra.id_proveedor AS Proveedor,
  'compra' AS Tipo
FROM
  compra
  JOIN proveedor ON proveedor.rut = compra.id_proveedor;

--___________________________________________________________________________________________________________________________
-- • Listar todas las producciones del año 2020 que contengan las 5 cecinas más vendidas
--___________________________________________________________________________________________________________________________
INSERT INTO maquinaria (nombre) VALUES('maquinaria1');
INSERT INTO maquinaria (nombre) VALUES('maquinaria2');

INSERT INTO plantaprod (nombre, id_maquinaria) VALUES('plantaprod1', 1);
INSERT INTO plantaprod (nombre, id_maquinaria) VALUES('plantaprod2', 2);

INSERT INTO produccion (fechainicio, fechatermino, id_plantaprod) VALUES ('2022-01-01', '2024-01-01', 1);
INSERT INTO produccion (fechainicio, fechatermino, id_plantaprod) VALUES ('2010-01-01', '2024-01-01', 2);

INSERT INTO receta (nombre) VALUES('receta1');
INSERT INTO receta (nombre) VALUES('receta2');

INSERT INTO bodega (nombre) VALUES('bodega1');
INSERT INTO bodega (nombre) VALUES('bodega2');

INSERT INTO detproduccion (cantidadEsperada, cantidadobtenida, fechainicio, fechatermino, id_receta, id_bodega, id_produccion) VALUES (10, 5, '2022-01-01', '2024-01-01', 1, 1, 1);
INSERT INTO detproduccion (cantidadEsperada, cantidadobtenida, fechainicio, fechatermino, id_receta, id_bodega, id_produccion) VALUES (10, 5, '2010-01-01', '2024-01-01', 2, 2, 2);

-- Armamos una tabla con las cecinas más vendidas
WITH maxCecina AS (
    SELECT detVenta.id_cecina
    FROM detVenta
    JOIN venta ON venta.venta_numerofactura = detVenta.id_venta_numerofactura
    WHERE EXTRACT(YEAR FROM venta.fechaventa) = 2020
    GROUP BY detVenta.id_cecina
    ORDER BY SUM (detVenta.cantidad) DESC
    LIMIT 5
)

-- seleccionamos los datos a presentar en tabla
SELECT
    produccion.id AS id_Produccion,
    produccion.fechainicio AS FechaInicio,
    produccion.fechatermino AS FechaTermino,
    detproduccion.cantidadEsperada AS CantidadEsperada,
    detproduccion.cantidadObtenida AS CantidadObtenida,
    cecina.nombre AS cecina
FROM produccion
--Relaciones entre las tablas con las columnas correspondientes
  JOIN detproduccion ON detProduccion.id_produccion = produccion.id
  JOIN receta ON detproduccion.id_receta = receta.id
  JOIN detreceta ON detreceta.id_receta = receta.id
  JOIN cecina ON detReceta.id_cecina = cecina.id
-- Filtramos para mostrar solo las 5 cecinas más vendidas
WHERE 
  produccion.fechainicio BETWEEN '2020-01-01' AND '2020-12-31'
  AND cecina.id IN (SELECT id_cecina FROM maxCecina);