CREATE TABLE viaje (
via_id INT(11) AUTO_INCREMENT NOT NULL PRIMARY KEY,
usu_cc INT(11) NOT NULL,
con_cc INT(11) NOT NULL,
fecha DATETIME,
FOREIGN KEY (usu_cc) REFERENCES usuario(usu_cc),
FOREIGN KEY (con_cc) REFERENCES conductor(usu_cc)
);
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Riascos'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Claudia' AND usu_apellido = 'Mendez'), '2017-10-25 20:00:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Riascos'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), '2019-03-15 18:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Riascos'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), '2019-05-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Pedro' AND usu_apellido = 'Perez'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Claudia' AND usu_apellido = 'Mendez'), '2018-05-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Pedro' AND usu_apellido = 'Perez'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), '2020-01-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), '2019-05-20 20:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Carlos' AND usu_apellido = 'Penagos'), '2018-06-22 21:30:00');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), '2020-03-17 15:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'), '2020-03-17 15:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'), '2020-04-10 18:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Jorge' AND usu_apellido = 'Rodriguez'), '2020-02-17 20:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'), '2020-02-20 16:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Luis' AND usu_apellido = 'Rojas'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), '2020-03-27 18:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Andres' AND usu_apellido = 'Cruz'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), '2020-03-20 21:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Ana' AND usu_apellido = 'Lopez'), '2020-01-10 17:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Maria' AND usu_apellido = 'Lopez'), '2020-02-15 20:30:20');
INSERT INTO viaje(usu_cc, con_cc, fecha) VALUES((SELECT usu_cc FROM usuario WHERE usu_nombre = 'Nelson' AND usu_apellido = 'Ruiz'),
(SELECT usu_cc FROM usuario WHERE usu_nombre = 'Jorge' AND usu_apellido = 'Rodriguez'), '2020-03-17 18:30:20');