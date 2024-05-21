drop database if exists lander2024;
create database lander2024;

use lander2024;

-- Usuarios
create table usuario(
id_usuario int auto_increment primary key,
nick varchar(8) not null,
pwd varchar(16) not null,
grupo varchar(4) not null,
fechaUC date not null,
num_com int default 0,
estado tinyint default 0  -- 0 no esta jugando y 1 esta jugando
);

-- Lander
create table lander(
id_lander int auto_increment primary key,
nombre varchar(32) not null,
t_a float default 0, -- tren de ate
fuel int not null -- deposito combustible
);
-- Modificada la clave principal

create table perfil_pot(
id_perfil int not null,
nivel int not null,
valor int not null,
primary key(id_perfil,nivel)
);

create table confg_pot(
id_perfil int not null,-- fk
id_la int not null, -- fk
id_config int auto_increment primary key
);

create table escenario(
id_escenario int auto_increment primary key,
nombre varchar(24) not null, -- Nombre de la estrella/planeta
gravedad float not null, -- Gravedad del cuerpo astral
ve float not null, -- velocida de entrada
he int not null -- altura de entrada
);

create table simulacion(
id_sim int auto_increment primary key,
id_usuario int not null, -- fk
id_lander int not null,
id_escenario int not null,
fecha date not null
);



create table datos_sim(
tiempo int not null,
vel float not null,
fuel float not null,
dist float not null,
id_sim int not null
);

create table puntuacion(
id_usuario int not null,
tiempo int not null,
fuel float not null,
fecha timestamp);

-- CONTRIBUCIONES AL DESARROLLO
create table contrib(
name VARCHAR(64),
phase VARCHAR(64)
);

-- ----------- CLAVES FORÁNEAS -----------

ALTER TABLE simulacion ADD FOREIGN KEY (id_usuario)   references usuario(id_usuario);
ALTER TABLE simulacion ADD FOREIGN KEY (id_lander)    references lander(id_lander);
ALTER TABLE simulacion ADD FOREIGN KEY (id_escenario) references escenario(id_escenario);
ALTER TABLE puntuacion ADD FOREIGN KEY (id_usuario)   references usuario(id_usuario);
ALTER TABLE confg_pot  ADD FOREIGN KEY (id_la)        references lander(id_lander);
ALTER TABLE confg_pot  ADD FOREIGN KEY (id_perfil) references perfil_pot(id_perfil);
ALTER TABLE datos_sim  ADD FOREIGN KEY  (id_sim)      references simulacion(id_sim);

-- FUNCIONES Y PROCEDIMIENTOS
