create database if not exists taquitos;
use taquitos;
#drop database taquitos;


create table if not exists ingrediente_tipo(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    cant_max int not null

)engine innodb;


create table if not exists pedidos(
	id int not null primary key auto_increment,
    fecha date not null,
    precio_total int not null

)engine innodb;

create table if not exists pedido_backup(
	id int not null primary key auto_increment,
    fecha date not null,
    precio_total int not null
)engine innodb;

create table if not exists taco(
	id int not null primary key auto_increment,
    id_pedido int not null,
    vcosto int not null,
    foreign key(id_pedido) references pedido(id)

)engine innodb;


create table if not exists ingrediente(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    precio int not null,
    id_tipo_ingrediente int not null,
    baja boolean default 0,
    foreign key(id_tipo_ingrediente) references ingrediente_tipo(id)

)engine innodb;

create table if not exists ingrediente_taco(
	id_ingrediente int not null,
    id_taco int not null,
    precio_ingrediente int not null,
    foreign key(id_ingrediente) references ingrediente(id),
    foreign key(id_taco) references taco(id)
    
)engine innodb;



create trigger respaldo after insert on pedido for each row 
insert into pedido_backup( fecha,precio_total) values(new.fecha,new.precio_total,now());




#ALTER TABLE `taquitos`.`ing_taco` 
#RENAME TO  `taquitos`.`ingrediente_taco` ;

#ALTER TABLE `taquitos`.`backup_pedido` 
#RENAME TO  `taquitos`.`pedido_backup` ;

INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('tortilla', '2');
INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('salsa', '3');
INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('verdura', '2');
INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('carne', '2');
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Cheddar',50,2);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Picante',30,2);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Pico de gallo',80,2);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Queso Crema',50,2);

insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Trigo',100,1);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Maiz',100,1);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Integral',100,1);

insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Carne',150,3);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('lechuga',50,3);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Pollo',100,3);
insert into ingrediente(nombre,precio,id_tipo_ingrediente) values ('Arroz',50,3);

UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '1');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '2');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '3');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '4');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '5');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '6');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '7');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '8');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '9');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '10');
UPDATE `taquitos`.`ingrediente` SET `baja` = '0' WHERE (`id` = '11');
