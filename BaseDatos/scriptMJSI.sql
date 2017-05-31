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
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `MJSIDataBase`.`Objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MJSIDataBase`.`Objeto` (
  `idObjeto` INT NOT NULL AUTO_INCREMENT,
  `nombreObjeto` VARCHAR(45) NOT NULL,
  `formaAdquisicion` VARCHAR(45) NULL,
  `fechaIngreso` VARCHAR(45) NULL,
  `numRegistro` VARCHAR(45) NULL,
  `valorEconomico` VARCHAR(45) NULL,
  `nombreFuente` VARCHAR(45) NULL,
  `fechaInventario` VARCHAR(45) NULL,
  `numInventario` VARCHAR(45) NULL,
  `otrosNumeros` VARCHAR(45) NULL,
  `direccionFuente` VARCHAR(45) NULL,
  `fechaCatalogo` VARCHAR(45) NULL,
  `numCatalogo` VARCHAR(45) NULL,
  `espesor` VARCHAR(45) NULL,
  `alto` VARCHAR(45) NULL,
  `ancho` VARCHAR(45) NULL,
  `largo` VARCHAR(45) NULL,
  `diametro` VARCHAR(45) NULL,
  `peso` VARCHAR(45) NULL,
  `procedencia` VARCHAR(45) NULL,
  `materiaYTecnica` VARCHAR(45) NULL,
  `numeroNegativo` VARCHAR(45) NULL,
  `autor` VARCHAR(45) NULL,
  `epoca` VARCHAR(45) NULL,
  `descripcion` VARCHAR(500) NULL,
  `documentacion` VARCHAR(500) NULL,
  `observaciones` VARCHAR(500) NULL,
  `recibio` VARCHAR(45) NULL,
  `inventario` VARCHAR(45) NULL,
  `catalogo` VARCHAR(45) NULL,
  `aprobo` VARCHAR(45) NULL,
  PRIMARY KEY (`idObjeto`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
