CREATE TABLE productos (
   id SERIAL PRIMARY KEY,
   nombre VARCHAR(100) NOT NULL,
   descripcion VARCHAR(200) NOT NULL,
   precioUnitario INT NOT NULL
);

INSERT INTO productos (nombre, descripcion, precioUnitario)
VALUES
    ('Laptop', 'Potente laptop para trabajo', 1500000),
    ('Smartphone', 'Teléfono inteligente de última generación', 650000),
    ('Auriculares', 'Auriculares inalámbricos con cancelación de ruido', 29999),
    ('Monitor', 'Monitor 4K de 27 pulgadas', 145799),
    ('Teclado', 'Teclado mecánico para gaming', 130899);