
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
