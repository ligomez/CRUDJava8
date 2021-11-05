CREATE TABLE vehiculo (
veh_placa CHAR(7) PRIMARY KEY,
veh_marca CHAR(15),
veh_modelo CHAR(15),
veh_anio SMALLINT(6),
veh_capacidad TINYINT(4),
veh_color CHAR(15),
veh_kilometros INT(11)
);
INSERT INTO vehiculo VALUES('KLM 565', 'Chevrolet', 'spark', 2015, 5, 'amarillo', 120000);
INSERT INTO vehiculo VALUES('LCS 364', 'Chevrolet', 'spark', 2016, 5, 'blanco', 125000);
INSERT INTO vehiculo VALUES('KGH 211', 'Kia', 'picanto', 2015, 5, 'amarillo', 80000);
INSERT INTO vehiculo VALUES('PET 363', 'Kia', 'rio', 2019, 5, 'blanco', 150000);
INSERT INTO vehiculo VALUES('CUL 073', 'Renault', 'duster', 2006, 5, 'blanco', 220000);
INSERT INTO vehiculo VALUES('PEL 456', 'Renault', 'duster', 2015, 5, 'blanco', 130000);