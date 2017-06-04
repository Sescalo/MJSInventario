-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema MJSIDataBase
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MJSIDataBase` ;

-- -----------------------------------------------------
-- Schema MJSIDataBase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MJSIDataBase` DEFAULT CHARACTER SET utf8 ;
USE `MJSIDataBase` ;

-- -----------------------------------------------------
-- Table `MJSIDataBase`.`Objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MJSIDataBase`.`Objeto` (
  `idObjeto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreObjeto` VARCHAR(45) NOT NULL,
  `formaAdquisicion` VARCHAR(45) NULL DEFAULT NULL,
  `fechaIngreso` VARCHAR(45) NULL DEFAULT NULL,
  `numRegistro` VARCHAR(45) NULL DEFAULT NULL,
  `valorEconomico` VARCHAR(45) NULL DEFAULT NULL,
  `nombreFuente` VARCHAR(45) NULL DEFAULT NULL,
  `fechaInventario` VARCHAR(45) NULL DEFAULT NULL,
  `numInventario` VARCHAR(45) NULL DEFAULT NULL,
  `otrosNumeros` VARCHAR(45) NULL DEFAULT NULL,
  `direccionFuente` VARCHAR(45) NULL DEFAULT NULL,
  `fechaCatalogo` VARCHAR(45) NULL DEFAULT NULL,
  `numCatalogo` VARCHAR(45) NULL DEFAULT NULL,
  `espesor` VARCHAR(45) NULL DEFAULT NULL,
  `alto` VARCHAR(45) NULL DEFAULT NULL,
  `ancho` VARCHAR(45) NULL DEFAULT NULL,
  `largo` VARCHAR(45) NULL DEFAULT NULL,
  `diametro` VARCHAR(45) NULL DEFAULT NULL,
  `peso` VARCHAR(45) NULL DEFAULT NULL,
  `procedencia` VARCHAR(45) NULL DEFAULT NULL,
  `materiaYTecnica` VARCHAR(45) NULL DEFAULT NULL,
  `numeroNegativo` VARCHAR(45) NULL DEFAULT NULL,
  `autor` VARCHAR(45) NULL DEFAULT NULL,
  `epoca` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `documentacion` VARCHAR(500) NULL DEFAULT NULL,
  `observaciones` VARCHAR(500) NULL DEFAULT NULL,
  `recibio` VARCHAR(45) NULL DEFAULT NULL,
  `inventario` VARCHAR(45) NULL DEFAULT NULL,
  `catalogo` VARCHAR(45) NULL DEFAULT NULL,
  `aprobo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idObjeto`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `MJSIDataBase`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MJSIDataBase`.`Usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` INT(11) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `isAdmin` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `MJSIDataBase`.`Historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MJSIDataBase`.`Historial` (
  `idHistorial` INT NOT NULL AUTO_INCREMENT,
  `movimiento` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idHistorial`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
