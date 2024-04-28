create database huella_hidrica;
use huella_hidrica;

create table Departamento(
codigo varchar(5) not null primary key,
nombre varchar(120) not null
);

create table Municipio(
codigo_departamento varchar(5) not null,
codigo varchar(8) not null,
nombre varchar(120) not null,
primary key(codigo_departamento,codigo),
constraint fk1_Departamento_Municipio foreign key(codigo_departamento) references Departamento(codigo)
);

create table Vereda(
	codigo_departamento varchar(5) not null,
    codigo_municipio varchar(8) not null,
    codigo varchar(10) not null,
    nombre varchar(180) not null,
    primary key(codigo_departamento,codigo_municipio,codigo),
    constraint fk2_Municipio_Vereda foreign key(codigo_departamento,codigo_municipio) references Municipio(codigo_departamento,codigo)
);
-- use huella_hidrica;
#alter table vereda modify column codigo varchar(10) not null;
create table Finca(
	codigo varchar(5) not null primary key,
    nombre varchar(180) not null,
    humedad float  not null,
    precipitacion float  not null,
    codigo_departamento varchar(5) not null,
    codigo_municipio varchar(8) not null,
    codigo_vereda varchar(10) not null,
    constraint fk3_Vereda_Finca foreign key(codigo_departamento,codigo_municipio,codigo_vereda) references Vereda(codigo_departamento,codigo_municipio,codigo)
);
#use huella_hidrica;
#alter table Finca modify column codigo_vereda varchar(10) not null;
create table ConsumoAgua(
	codigo_finca varchar(5) not null,
    fecha date not null,
    cantidad float not null,
    tipoAgua varchar(20) not null,
    tipoUso varchar(20) not null,
    primary key(codigo_finca,fecha),
    constraint fk4_Finca_ConsumoAgua foreign key(codigo_finca) references Finca(codigo)
);

create table Potrero(
	codigo_finca varchar(5) not null,  
    codigo varchar(5) not null,
    areaPotrero float not null,
    capacidadAgua float not null,
    primary key(codigo_finca,codigo),
    constraint fk5_Finca_Potrero foreign key(codigo_finca) references Finca(codigo)
);

create table Pasto(
    codigo varchar(5) not null primary key,
    nombre varchar(15)not null
);

create table Potrero_Pasto(
    codigo_finca varchar(5) not null,
    codigo_potrero varchar(5) not null,
    codigo_pasto varchar(5) not null,
    primary key(codigo_finca,codigo_potrero,codigo_pasto),
    constraint fk6_Potrero_potreroPasto foreign key(codigo_finca, codigo_potrero) references Potrero(codigo_finca, codigo),
    constraint fk7_Pasto_potreroPasto foreign key(codigo_pasto) references Pasto(codigo)
);

create table Animal(
	codigo varchar(5) not null primary key,  
    peso float not null,
    fechaNacimiento date not null,
    raza varchar(15) not null,
    estado varchar(15) not null,
    codigo_finca varchar(5) not null,
    codigo_potrero varchar(5) not null,
    constraint fk8_Potrero_potreroPasto foreign key(codigo_finca, codigo_potrero) references Potrero(codigo_finca, codigo)
);

create table Leche(
	codigo_animal varchar(5) not null,  
    fecha date not null,
    cantidad float not null,
    primary key(codigo_animal,fecha),
    constraint fk9_Animal_Leche foreign key(codigo_animal) references Animal(codigo)
);



-- HACER LA IMPLEMENTACION DE DATOS TOMAR CAPTURA HACER UN EXCEL PARA IMPORTAR LOS DATOS 
-- hacer trigger que validen la insercion de datos y demas (LOS RANGOS DE DATOS QUE SE ESTABELCIERON EN EL DICICONARIO DE DATOS)
-- CREAR VISTA PARA cómo los animales están asignados a los potreros.- MOSTRAR EN TABLA 

#PROCEDIMIENTO: ver el consumo de agua promedio por animal en un potrero específico.
use huella_hidrica;
DELIMITER //
CREATE PROCEDURE ConsumoAguaPromedio_animal_potrero (IN p_codigo_finca VARCHAR(5), IN p_codigo_potrero VARCHAR(5), OUT p_promedio_consumo FLOAT)
BEGIN
	DECLARE total_consumo FLOAT;
    DECLARE total_animales INT;
    -- Calcular el total de consumo de agua en el potrero específico
    SELECT SUM(cantidad) INTO total_consumo
    FROM ConsumoAgua
    WHERE codigo_finca = p_codigo_finca
    AND codigo_finca IN (
		SELECT codigo 
		FROM Potrero 
		WHERE codigo_finca = p_codigo_finca AND codigo = p_codigo_potrero
        # está buscando si el código de finca está en un potrero específico.
    );

    -- Calcular el total de animales en el potrero específico
    SELECT COUNT(*) INTO total_animales
    FROM Animal
    WHERE codigo_finca = p_codigo_finca
    AND codigo_finca IN (
		SELECT codigo 
		FROM Potrero 
		WHERE codigo_finca = p_codigo_finca AND codigo = p_codigo_potrero
    );

    -- Calcular el consumo promedio por animal
    IF total_animales > 0 THEN
        SET p_promedio_consumo = total_consumo / total_animales;
    ELSE
        SET p_promedio_consumo = 0;
    END IF;
END;
//
DELIMITER ;


#LLAMARLO ASI
CALL VerConsumoAguaPromedio('codigo_finca', 'codigo_potrero', @promedio_consumo);
SELECT @promedio_consumo AS ConsumoAguaPromedio;


#PROCEDIMIENTO: consultar la cantidad de agua consumida en un período de tiempo específico entre todos los animales.

use huella_hidrica;
DELIMITER //

CREATE PROCEDURE ConsumoAgua_PorPeriodo_Animales( IN p_fecha_inicio DATE, IN p_fecha_fin DATE, OUT p_consumo_total FLOAT
)
BEGIN
    -- Declaración de una variable para almacenar el consumo total
    DECLARE total_consumo FLOAT;

    -- Calcular el total de consumo de agua en el período de tiempo específico
    SELECT SUM(cantidad) INTO total_consumo
    FROM ConsumoAgua
    WHERE fecha >= p_fecha_inicio AND fecha <= p_fecha_fin;

    -- Asignar el resultado al parámetro de salida
    SET p_consumo_total = total_consumo;
END //

DELIMITER ;

#llamar procedimeinto
CALL ConsultarConsumoAguaPorPeriodo('2023-01-01', '2023-12-31', @consumo_total);
SELECT @consumo_total AS ConsumoAguaTotal;


#PROCEDIMIENTO: CONSULTAR LA EDAD DE UN ANIMAL CONOCIENDO EL CODIGO

use huella_hidrica;

DELIMITER //

CREATE PROCEDURE EdadAnimal_PorCodigo( IN codigo_animal VARCHAR(5), OUT p_edad INT)
BEGIN
    DECLARE fecha_nacimiento DATE;
    DECLARE edad INT;

    -- Buscar la fecha de nacimiento del animal por su código
    SELECT fechaNacimiento INTO fecha_nacimiento
    FROM Animal
    WHERE codigo = codigo_animal;

    -- Calcular la edad en años
    SELECT DATEDIFF(CURDATE(), fecha_nacimiento) / 365 INTO edad;
    SET p_edad = edad;
END //
DELIMITER ;

#LLAMAR PROCEDIMIENTO
CALL CalcularEdadAnimalPorCodigo('ABC123', @edad_animal);
SELECT @edad_animal AS EdadAnimal;


#CREAR UNA VISTA LA USARLA
#LOS TRIGGERS 
#EL DICCIONAIO DE DATOS