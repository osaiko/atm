CREATE SCHEMA `atm`;

CREATE TABLE `atm`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pin` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `access` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `pin_UNIQUE` (`pin` ASC));