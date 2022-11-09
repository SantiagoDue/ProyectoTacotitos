create database if not exists taquitos;
use taquitos;
#drop database taquitos;


create table if not exists ingrediente_tipo(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    cant_max int not null

)engine innodb;

create table if not exists tipo_vehiculo(
	id int not null primary key auto_increment,
    tipo varchar(50),
    patente varchar(50)

)engine innodb;

create table if not exists repartidor(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    celular varchar(50) not null,
	vehiculo int not null,
    foreign key (vehiculo) references tipo_vehiculo(id)
    
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
    repartidor int,
    cliente int not null,
    precio_total int not null,
    con_envio boolean not null,
    foreign key(repartidor) references repartidor(id),
    foreign key (cliente) references cliente(id)

) engine innodb;

create table if not exists taco(
	id int not null primary key auto_increment,
    pedido int not null,
    vcosto int not null,
    foreign key(pedido) references pedido(id)

)engine innodb;


create table if not exists ingrediente(
	id int not null primary key auto_increment,
    nombre varchar(50) not null,
    precio int not null,
    tipo int not null,
    foreign key(tipo) references ingrediente_tipo(id)

)engine innodb;

create table if not exists ing_taco(
	ingrediente int not null,
    taco int not null,
    foreign key(ingrediente) references ingrediente(id),
    foreign key(taco) references taco(id)
    
)engine innodb;

create table if not exists backup_pedido(
	id int not null primary key,
    fecha date not null,
    repartidor int,
    cliente int not null,
    precio_total int not null,
    con_envio boolean not null

)engine innodb;

create trigger respaldo after insert on pedido for each row 
insert into backup_pedido(id, fecha,repartidor,cliente,precio_todal,con_envio) values(new.id,new.fecha,new.repartidor,new.cliente,new.precio_total,new.con_envio,now());


INSERT INTO `taquitos`.`cliente` (`nombre`, `celular`, `direccion`) VALUES ('juan', '123123', 'asdoasjkd123123');
INSERT INTO `taquitos`.`cliente` (`nombre`, `celular`, `direccion`) VALUES ('pepe', '444444', 'fnfnnfn 123');

ALTER TABLE `taquitos`.`ing_taco` 
RENAME TO  `taquitos`.`ingrediente_taco` ;

ALTER TABLE `taquitos`.`backup_pedido` 
RENAME TO  `taquitos`.`pedido_backup` ;

INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('tortilla', '2');
INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('salsa', '3');
INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('verdura', '2');
INSERT INTO `taquitos`.`ingrediente_tipo` (`nombre`, `cant_max`) VALUES ('carne', '2');


