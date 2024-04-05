#                         CARGA DE DATOS
#Departamentos:
--  INSERTADOS DESDE LA INTERFAZ
#Municipios:
--  INSERTADOS DESDE LA INTERFAZ
#Veredas: 20 REGISTROS
-- 25	Cundinamarca	25.843	Villa de San Diego de Ubate
-- 25	Cundinamarca	25.328	Guayabal de Siquima
-- 25	Cundinamarca	25.29	Fusagasugá
-- 13	Bolívar	        13.894	Zambrano
-- 13	Bolívar	        13.62	San Cristóbal
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.843', '25.843.001', 'Apartadero');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.843', '25.843.002', 'Centro del Llano');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.843', '25.843.003', 'Guatancuy');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.328', '25.328.010', 'Robledal');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.328', '25.328.008', 'Pueblo Viejo');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.328', '25.328.999', 'Expansion Urbana');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.29', '25.290.005', 'Bochica');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.29', '25.290.009', 'El Guavio');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.29', '25.290.011', 'El Placer');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.29', '25.290.021', 'Mesitas');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('25', '25.29', '25.290.022', 'Mosqueral');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('13', '13.894', '13.894.010', 'Tornovan Bajo');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('13', '13.894', '13.894.006', 'Tornovan Alto');
INSERT INTO `huella_hidrica`.`vereda` (`codigo_departamento`, `codigo_municipio`, `codigo`, `nombre`) VALUES ('13', '13.62', '13.620.001', 'Higueretal');

#Fincas:
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('ABC12', 'El progreso', '87', '15', '25', '25.843', '25.843.001');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('A001', 'Finca Apartadero 1', '80', '25', '25', '25.843', '25.843.001');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('A002', 'Finca Apartadero 2', '75', '20', '25', '25.843', '25.843.001');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('A003', 'Finca Apartadero 3', '82', '18', '25', '25.843', '25.843.001');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('A004', 'Finca Apartadero 4', '77', '22', '25', '25.843', '25.843.001');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('C001', 'Finca Centro del Llano 1', '85', '30', '25', '25.843', '25.843.002');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('C002', 'Finca Centro del Llano 2', '78', '22', '25', '25.843', '25.843.002');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('C003', 'Finca Centro del Llano 3', '90', '28', '25', '25.843', '25.843.002');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('C004', 'Finca Centro del Llano 4', '75', '20', '25', '25.843', '25.843.002');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('G001', 'Finca Guatancuy 1', '82', '18', '25', '25.843', '25.843.003');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('G002', 'Finca Guatancuy 2', '75', '20', '25', '25.843', '25.843.003');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('R001', 'Finca Robledal 1', '85', '30', '25', '25.328', '25.328.010');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('PV001', 'Finca Pueblo Viejo 1', '85', '30', '25', '25.328', '25.328.008');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EU001', 'Finca Expansion Urbana 1', '85', '30', '25', '25.328', '25.328.999');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EU002', 'Finca Expansion Urbana 2', '78', '22', '25', '25.328', '25.328.999');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('B001', 'Finca Bochica 1', '85', '30', '25', '25.29', '25.290.005');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('B002', 'Finca Bochica 2', '78', '22', '25', '25.29', '25.290.005');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EG001', 'Finca El Guavio 1', '85', '30', '25', '25.29', '25.290.009');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EP001', 'Finca El Placer 1', '85', '30', '25', '25.29', '25.290.011');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EP002', 'Finca El Placer 2', '78', '22', '25', '25.29', '25.290.011');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EM001', 'Finca Mesitas 1', '85', '30', '25', '25.29', '25.290.021');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EM002', 'Finca Mesitas 2', '78', '22', '25', '25.29', '25.290.021');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('EM003', 'Finca Mesitas 3', '90', '28', '25', '25.29', '25.290.021');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('M001', 'Finca Mosqueral 1', '85', '30', '25', '25.29', '25.290.022');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('M002', 'Finca Mosqueral 2', '78', '22', '25', '25.29', '25.290.022');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('M003', 'Finca Mosqueral 3', '90', '28', '25', '25.29', '25.290.022');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('TB001', 'Finca Tornovan Bajo 1', '85', '30', '13', '13.894', '13.894.010');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('TB002', 'Finca Tornovan Bajo 2', '78', '22', '13', '13.894', '13.894.010');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('TA001', 'Finca Tornovan Alto 1', '85', '30', '13', '13.894', '13.894.006');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('TA002', 'Finca Tornovan Alto 2', '78', '22', '13', '13.894', '13.894.006');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('TA003', 'Finca Tornovan Alto 3', '90', '28', '13', '13.894', '13.894.006');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('H001', 'Finca Higueretal 1', '85', '30', '13', '13.62', '13.620.001');
INSERT INTO `huella_hidrica`.`finca` (`codigo`, `nombre`, `humedad`, `precipitacion`, `codigo_departamento`, `codigo_municipio`, `codigo_vereda`) VALUES ('H002', 'Finca Higueretal 2', '78', '22', '13', '13.62', '13.620.001');

#Consumo de Agua:
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('ABC12', '2023-09-10', '500', 'Río', 'Limpieza');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('ABC12', '2023-09-11', '600', 'Pozo', 'Consumo Animal');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('ABC12', '2023-09-12', '450', 'Lluvias', 'Riego');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('ABC12', '2023-09-13', '700', 'Río', 'Limpieza');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('A001', '2023-09-10', '400', 'Pozo', 'Consumo Animal');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('A001', '2023-09-11', '550', 'Lluvias', 'Riego');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('A001', '2023-09-12', '300', 'Pozo', 'Limpieza');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('A002', '2023-09-10', '450', 'Lluvias', 'Riego');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('A002', '2023-09-11', '700', 'Pozo', 'Consumo Animal');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('A002', '2023-09-12', '350', 'Río', 'Consumo Animal');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('C002', '2023-09-10', '550', 'Lluvias', 'Riego');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('C002', '2023-09-11', '720', 'Pozo', 'Limpieza');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('C002', '2023-09-12', '380', 'Río', 'Consumo Animal');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('C002', '2023-09-13', '620', 'Pozo', 'Consumo Animal');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('G002', '2023-09-10', '480', 'Lluvias', 'Riego');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('G002', '2023-09-11', '680', 'Pozo', 'Limpieza');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('G002', '2023-09-12', '420', 'Río', 'Consumo Animal');
INSERT INTO `huella_hidrica`.`consumoagua` (`codigo_finca`, `fecha`, `cantidad`, `tipoAgua`, `tipoUso`) VALUES ('G002', '2023-09-13', '580', 'Pozo', 'Consumo Animal');

#Potreros:
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('ABC12', 'ABC01', '200', '350');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('ABC12', 'ABC02', '180', '520');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('ABC12', 'ABC03', '220', '380');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('ABC12', 'ABC04', '190', '440');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('ABC12', 'ABC05', '210', '260');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('ABC12', 'ABC06', '250', '350');

INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('G002', 'G0201', '210', '260');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('G002', 'G0202', '200', '350');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('G002', 'G0203', '180', '300');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('G002', 'G0204', '220', '400');

INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('C002', 'C0201', '250', '450');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('C002', 'C0202', '190', '320');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('C002', 'C0203', '200', '350');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('C002', 'C0204', '180', '520');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('C002', 'C0205', '220', '380');

INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('A002', 'A0201', '190', '440');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('A002', 'A0202', '210', '260');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('A002', 'A0203', '200', '350');

INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('A001', 'A0101', '180', '300');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('A001', 'A0102', '220', '400');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('A001', 'A0103', '250', '450');
INSERT INTO `huella_hidrica`.`potrero` (`codigo_finca`, `codigo`, `areaPotrero`, `capacidadAgua`) VALUES ('A001', 'A0104', '190', '320');

#Pastos:
INSERT INTO `huella_hidrica`.`pasto` (`codigo`, `nombre`) VALUES ('BRA01', 'Brachiaria Decumbens');
INSERT INTO `huella_hidrica`.`pasto` (`codigo`, `nombre`) VALUES ('KIK01', 'Kikuyo');
INSERT INTO `huella_hidrica`.`pasto` (`codigo`, `nombre`) VALUES ('BRA02', 'Brachiaria Brizantha');

#Pastos en Potreros:
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('ABC12', 'ABC01', 'BRA01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('ABC12', 'ABC02', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('ABC12', 'ABC03', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('ABC12', 'ABC04', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('ABC12', 'ABC05', 'BRA02');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('ABC12', 'ABC06', 'BRA02');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('ABC12', 'ABC06', 'BRA01');

INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('G002', 'G0201', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('G002', 'G0202', 'BRA02');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('G002', 'G0203', 'BRA02');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('G002', 'G0204', 'BRA02');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('G002', 'G0204', 'BRA01');

INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('C002', 'C0201', 'BRA02');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('C002', 'C0202', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('C002', 'C0203', 'BRA02');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('C002', 'C0204', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('C002', 'C0205', 'BRA01');

INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A002', 'A0201', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A002', 'A0202', 'BRA01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A002', 'A0203', 'BRA01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A002', 'A0203', 'BRA02');

INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A001', 'A0101', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A001', 'A0102', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A001', 'A0103', 'KIK01');
INSERT INTO `huella_hidrica`.`potrero_pasto` (`codigo_finca`, `codigo_potrero`, `codigo_pasto`) VALUES ('A001', 'A0104', 'BRA01');


#Animales:

INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A001', '500', '2022-01-15', 'Holstein', 'Normal', 'ABC12', 'ABC01');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A002', '480', '2022-02-20', 'Angus', 'Enfermo', 'ABC12', 'ABC01');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A003', '550', '2022-03-10', 'Hereford', 'Gestación', 'ABC12', 'ABC01');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A004', '490', '2022-04-25', 'Simmental', 'Lactancia', 'ABC12', 'ABC01');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A005', '510', '2022-05-15', 'Charolais', 'Normal', 'ABC12', 'ABC01');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A006', '480', '2022-06-20', 'Limousin', 'Enfermo', 'ABC12', 'ABC01');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A007', '540', '2022-07-10', 'Angus', 'Normal', 'ABC12', 'ABC01');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A008', '520', '2022-08-25', 'Hereford', 'Gestación', 'ABC12', 'ABC01');

INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A009', '450', '2020-01-15', 'Holstein', 'normal', 'ABC12', 'ABC02');
INSERT INTO `huella_hidrica`.`animal` (`codigo`, `peso`, `fechaNacimiento`, `raza`, `estado`, `codigo_finca`, `codigo_potrero`) VALUES ('A010', '500', '2019-08-22', 'Angus', 'gestación', 'ABC12', 'ABC02');

#Producción de Leche:	
INSERT INTO `huella_hidrica`.`leche` (`codigo_animal`, `fecha`, `cantidad`) VALUES ('A004', '2023-09-08', '8');
INSERT INTO `huella_hidrica`.`leche` (`codigo_animal`, `fecha`, `cantidad`) VALUES ('A004', '2023-09-09', '10');
INSERT INTO `huella_hidrica`.`leche` (`codigo_animal`, `fecha`, `cantidad`) VALUES ('A004', '2023-09-10', '7');
INSERT INTO `huella_hidrica`.`leche` (`codigo_animal`, `fecha`, `cantidad`) VALUES ('A004', '2023-09-11', '9');