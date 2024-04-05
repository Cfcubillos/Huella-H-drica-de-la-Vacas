#vista
CREATE TABLE vacas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    peso DECIMAL(5,2) NOT NULL
);

INSERT INTO vacas (nombre, peso) VALUES
('Vaca1', 500.00),
('Vaca2', 600.50),
('Vaca3', 450.75),
('Vaca4', 550.25),
('Vaca5', 700.00);

#consumo de agua
ALTER TABLE vacas
ADD COLUMN consumo_agua DECIMAL(5,2);

UPDATE vacas
SET consumo_agua = 10.25
WHERE id = 1;

UPDATE vacas
SET consumo_agua = 8.50
WHERE id = 2;

UPDATE vacas
SET consumo_agua = 12.75
WHERE id = 3;

UPDATE vacas
SET consumo_agua = 15.00
WHERE id = 4;

UPDATE vacas
SET consumo_agua = 11.20
WHERE id = 5;


#vista para analizar los consumos de agua
CREATE VIEW vista_consumo_agua AS
SELECT id, nombre, peso, consumo_agua
FROM vacas
WHERE id_vaca = 'ID_DE_LA_VACA_A_VISUALIZAR';



