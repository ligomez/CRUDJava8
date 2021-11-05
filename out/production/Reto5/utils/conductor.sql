CREATE TABLE conductor (
usu_cc INT(11) NOT NULL PRIMARY KEY,
veh_placa CHAR(7),
FOREIGN KEY (usu_cc) REFERENCES usuario(usu_cc),
FOREIGN KEY (veh_placa) REFERENCES vehiculo(veh_placa)
);
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Claudia' AND usu_apellido = 'Mendez'), 'KLM 565');
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), 'KLM 565');
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'), 'LCS 364');
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), 'PET 363');
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Carlos' AND usu_apellido = 'Penagos'), 'PET 363');
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), 'LCS 364');
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), 'KGH 211');
INSERT INTO conductor VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Jorge' AND usu_apellido = 'Rodriguez'), 'KGH 211');