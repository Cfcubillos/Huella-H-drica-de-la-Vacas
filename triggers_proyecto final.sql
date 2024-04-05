#triggers
########################################################################################11111111111111111111111
#crear la tabla tutoria en donde se van a guardar los registros de cuando se inserte,se elimine o se actualice una finca
-- Crear la tabla terrenos
CREATE TABLE terrenos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    area DECIMAL(8,2) NOT NULL
    -- Puedes agregar más columnas según sea necesario
);

-- Crear la tabla tutoria_terrenos
CREATE TABLE tutoria_terrenos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    evento VARCHAR(50) NOT NULL,
    descripcion TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear el trigger para insertar, actualizar y eliminar registros en la tabla tutoria_terrenos
DELIMITER //
CREATE TRIGGER tr_terrenos_tutoria
AFTER INSERT OR UPDATE OR DELETE ON terrenos
FOR EACH ROW
BEGIN
    DECLARE evento_tipo VARCHAR(50);

    IF (INSERTING()) THEN
        SET evento_tipo = 'Inserción';
    ELSEIF (UPDATING()) THEN
        SET evento_tipo = 'Actualización';
    ELSE
        SET evento_tipo = 'Eliminación';
    END IF;

    INSERT INTO tutoria_terrenos (evento, descripcion)
    VALUES (evento_tipo, 
            CASE 
                WHEN INSERTING() THEN CONCAT('Se ha insertado un nuevo terreno con ID: ', NEW.id)
                WHEN UPDATING() THEN CONCAT('Se ha actualizado el terreno con ID: ', NEW.id)
                WHEN DELETING() THEN CONCAT('Se ha eliminado el terreno con ID: ', OLD.id)
            END);
END;
//
DELIMITER ;



###############################################################################################################2222222#################
#crear la tabla tutoria_vacas en donde se van a guardar los registros de cuando se inserte,se elimine o se actualce una vaca

-- Crear la tabla tutoria
CREATE TABLE tutoria (
    id INT PRIMARY KEY AUTO_INCREMENT,
    evento VARCHAR(50) NOT NULL,
    descripcion TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear el trigger para insertar, actualizar y eliminar registros en la tabla tutoria
DELIMITER //
CREATE TRIGGER tr_vacas_tutoria
AFTER INSERT OR UPDATE OR DELETE ON vacas
FOR EACH ROW
BEGIN
    DECLARE evento_tipo VARCHAR(50);

    IF (INSERTING()) THEN
        SET evento_tipo = 'Inserción';
    ELSEIF (UPDATING()) THEN
        SET evento_tipo = 'Actualización';
    ELSE
        SET evento_tipo = 'Eliminación';
    END IF;

    INSERT INTO tutoria (evento, descripcion)
    VALUES (evento_tipo, 
            CASE 
                WHEN INSERTING() THEN CONCAT('Se ha insertado una nueva vaca con ID: ', NEW.id)
                WHEN UPDATING() THEN CONCAT('Se ha actualizado la vaca con ID: ', NEW.id)
                WHEN DELETING() THEN CONCAT('Se ha eliminado la vaca con ID: ', OLD.id)
            END);
END;
//
DELIMITER ;
################################################################################################################33333333##################
#agrega la tabla donde se va a mostrar el trigger y despues si  el trigger normal,los datos que deben mirarsen son id,nombre,y edad
#1. *Validación de Edad del Animal:*
 #- Verificar que la fecha de nacimiento del animal esté en un formato correcto y que la edad calculada sea coherente.


CREATE TABLE animales (
    od INT PRIMARY KEY,
    nombre VARCHAR(255),
    fecha_nacimiento DATE,
    edad INT
);

#trigger
DELIMITER //
CREATE TRIGGER valida_edad_animal BEFORE INSERT ON animales
FOR EACH ROW
BEGIN
    DECLARE fecha_nacimiento_valida BOOLEAN;

    -- Verifica que la fecha de nacimiento esté en un formato correcto
    SET fecha_nacimiento_valida = TRUE;
    IF NEW.fecha_nacimiento IS NULL OR NEW.fecha_nacimiento <= '1900-01-01' OR NEW.fecha_nacimiento > CURDATE() THEN
        SET fecha_nacimiento_valida = FALSE;
    END IF;

    -- Calcula la edad y verifica que sea coherente
    IF fecha_nacimiento_valida THEN
        SET NEW.edad = YEAR(CURDATE()) - YEAR(NEW.fecha_nacimiento) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(NEW.fecha_nacimiento, '%m%d'));
    ELSE
        -- Si la fecha de nacimiento no es válida, establece la edad como NULL o algún valor predeterminado
        SET NEW.edad = NULL; 
    END IF;
END;
//
DELIMITER ;

############################################################################################################44444444444444############
#los datos que deben mirarsen son id,nombre,especie,peso
#5. *Validación de Peso del Animal:*
#- Verificar que el peso registrado del animal no sea negativo y esté dentro de rangos esperados para la especie.
CREATE TABLE animales_datos (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    especie VARCHAR(255),
    peso DECIMAL(10,2)
);

DELIMITER //
CREATE TRIGGER valida_peso_animal BEFORE INSERT ON animales_datos
FOR EACH ROW
BEGIN
    DECLARE especie_valida BOOLEAN;

    -- Verifica que la especie del animal sea válida (puedes ajustar esto según tus necesidades)
    SET especie_valida = TRUE;
    IF NEW.especie NOT IN ('Especie1', 'Especie2', 'Especie3') THEN
        SET especie_valida = FALSE;
    END IF;

    -- Verifica que el peso registrado no sea negativo y esté dentro de rangos esperados para la especie
    IF NEW.peso < 0 OR (especie_valida AND (NEW.peso < 5 OR NEW.peso > 200)) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Peso no válido para la especie';
    END IF;
END;
//
DELIMITER ;

