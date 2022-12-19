create database if not exists taquitos2;
use taquitos2;

create table if not exists ingrediente_tipo(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    cant_max int not null

)engine innodb;

create table if not exists tipo_vehiculo(
	id int not null primary key auto_increment,
    tipo varchar(50)
)engine innodb;

create table if not exists vehiculo(
	id int not null primary key auto_increment,
    patente varchar(50),
    tipo int not null,
    foreign key (tipo) references tipo_vehiculo(id)
)engine innodb;

create table if not exists repartidor(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    celular varchar(50) not null,
	vehiculo int not null,
    baja boolean,
    foreign key (vehiculo) references vehiculo(id)
    
)engine innodb;

create table if not exists cliente(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    celular varchar(50),
    direccion varchar (50) not null
    
)engine innodb;

create table if not exists pedido(
	id int not null primary key auto_increment,
    fecha date not null,
    id_repartidor int,
    id_cliente int,
    precio_total int not null,
    con_envio int,
    foreign key(id_repartidor) references repartidor(id),
    foreign key (id_cliente) references cliente(id)

) engine innodb;

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
    tipo int not null,
    baja boolean,
    foreign key(tipo) references ingrediente_tipo(id)

)engine innodb;

create table if not exists ingrediente_taco(
	id_ingrediente int not null,
    id_taco int not null,
    foreign key(id_ingrediente) references ingrediente(id),
    foreign key(id_taco) references taco(id)
    
)engine innodb;



create table if not exists pedido_backup(
	id int not null primary key auto_increment,
    fecha date not null,
    repartidor int,
    cliente int,
    precio_total int not null,
    con_envio boolean

)engine innodb;


/*create trigger respaldo after insert on pedido for each row 
insert into pedido_backup(id, fecha,id_repartidor,id_cliente,precio_todal,con_envio)
 values(new.id,new.fecha,new.id_repartidor,new.id_cliente,new.precio_total,new.con_envio);*/


#ALTER TABLE `taquitos`.`ing_taco` 
#RENAME TO  `taquitos`.`ingrediente_taco` ;

#ALTER TABLE `taquitos`.`backup_pedido` 
#RENAME TO  `taquitos`.`pedido_backup` ;

INSERT INTO `taquitos2`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('tortilla', '2');
INSERT INTO `taquitos2`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('salsa', '1');
INSERT INTO `taquitos2`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('alimento', '5');


insert into tipo_vehiculo (tipo) values ('Auto');
insert into tipo_vehiculo (tipo) values ('Moto');

insert into vehiculo (patente, tipo) values ('DUE274',1);
insert into vehiculo (patente, tipo) values ('UWU213',2);

insert into repartidor (nombre,celular,vehiculo) values ('Federico','229147354',2);
insert into repartidor (nombre,celular,vehiculo) values ('Mike','229128444',1);

insert into ingrediente(nombre,precio,tipo) values ('Cheddar',50,2);
insert into ingrediente(nombre,precio,tipo) values ('Picante',30,2);
insert into ingrediente(nombre,precio,tipo) values ('Pico de gallo',80,2);
insert into ingrediente(nombre,precio,tipo) values ('Queso Crema',50,2);

insert into ingrediente(nombre,precio,tipo) values ('Trigo',100,1);
insert into ingrediente(nombre,precio,tipo) values ('Maiz',100,1);
insert into ingrediente(nombre,precio,tipo) values ('Integral',100,1);

insert into ingrediente(nombre,precio,tipo) values ('Carne',150,3);
insert into ingrediente(nombre,precio,tipo) values ('lechuga',50,3);
insert into ingrediente(nombre,precio,tipo) values ('Pollo',100,3);
insert into ingrediente(nombre,precio,tipo) values ('Arroz',50,3);
insert into ingrediente(nombre,precio,tipo) values ('Tomate',50,3);


insert into cliente(nombre,celular,direccion) values('Ailen','2291343633','una calle verdadera');	
insert into cliente(nombre,celular,direccion) values('Miguel','229176563','erramouspe 1533');	
insert into cliente(nombre,celular,direccion) values('Flor','22918763444','calle 24 n 1500');	
insert into cliente(nombre,celular,direccion) values('Caro','22919090909','calle 7 entre 28 y 30');	


INSERT INTO `taquitos2`.`pedido` (`fecha`, `id_repartidor`, `id_cliente`, `precio_total`, `con_envio`) VALUES ("2022" "03" "18", 1, '1', '1000', '50');
INSERT INTO `taquitos2`.`pedido` (`fecha`, `id_repartidor`, `id_cliente`, `precio_total`, `con_envio`) VALUES ("2022" "03" "15", 1, '1', '2000', '70');
INSERT INTO `taquitos2`.`pedido` (`fecha`, `id_repartidor`, `id_cliente`, `precio_total`, `con_envio`) VALUES ("2022" "03" "15", 1, '2', '3000', '0');




DELIMITER $$
USE `taquitos2`$$
CREATE PROCEDURE `getPedidosPorClienteID` (id INT(10))
BEGIN
	SELECT *  FROM pedido
	WHERE pedido.id_cliente=id;
END$$

DELIMITER ;


DELIMITER $$
USE `taquitos2`$$
CREATE PROCEDURE `getPedidosPorCliente` ( nombre varchar(50))
BEGIN
	
	SELECT *  FROM pedido
	WHERE id_cliente=(
		select id from cliente
		where nombre=nombre
    );
END$$

DELIMITER ;

DELIMITER $$
USE `taquitos2`$$
CREATE PROCEDURE `getRecaudadoDelivery` ( desde date,hasta date)
BEGIN
	
	SELECT sum(con_envio)  FROM pedido
    where (desde<fecha) AND (hasta>fecha);
	
END$$

DELIMITER ;

#CALL getPedidosPorCliente(Ailen);
#CALL getPedidosPorClienteID(1);
CALL GetRecaudadoDelivery(2022-03-12,2022-03-16);
