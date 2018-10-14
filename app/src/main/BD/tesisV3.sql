/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 14.1 		*/
/*  Created On : 02-oct.-2018 10:12:49 p.m. 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `atractivo` CASCADE
;

DROP TABLE IF EXISTS `atractivoRuta` CASCADE
;

DROP TABLE IF EXISTS `avatar` CASCADE
;

DROP TABLE IF EXISTS `departamento` CASCADE
;

DROP TABLE IF EXISTS `logro` CASCADE
;

DROP TABLE IF EXISTS `logroObjetivo` CASCADE
;

DROP TABLE IF EXISTS `municipio` CASCADE
;

DROP TABLE IF EXISTS `objetivo` CASCADE
;

DROP TABLE IF EXISTS `ruta` CASCADE
;

DROP TABLE IF EXISTS `tipoRuta` CASCADE
;

DROP TABLE IF EXISTS `usuario` CASCADE
;

DROP TABLE IF EXISTS `usuarioLogro` CASCADE
;

/* Create Tables */

CREATE TABLE `atractivo`
(
	`idAtractivo` INT NOT NULL AUTO_INCREMENT,
	`nombreAtractivo` VARCHAR(50) NOT NULL,
	`longitudAtractivo` DOUBLE(10,2) NOT NULL,
	`latitudAtractivo` DOUBLE(10,2) NOT NULL,
	`descripcionAtractivo` TEXT NOT NULL,
	`idInstagram` INT NOT NULL,
	`idMunicipio` INT NOT NULL,
	CONSTRAINT `PK_atractivo` PRIMARY KEY (`idAtractivo` ASC)
)

;

CREATE TABLE `atractivoRuta`
(
	`idAtractivoRuta` INT NOT NULL AUTO_INCREMENT,
	`idAtractivo` INT NOT NULL,
	`idRuta` INT NOT NULL,
	CONSTRAINT `PK_atractivoRuta` PRIMARY KEY (`idAtractivoRuta` ASC)
)

;

CREATE TABLE `avatar`
(
	`idAvatar` INT NOT NULL,
	`nombreAvatar` VARCHAR(50) NOT NULL,
	`urlAvatar` VARCHAR(250) NOT NULL,
	`idRuta` INT NOT NULL,
	CONSTRAINT `PK_avatar` PRIMARY KEY (`idAvatar` ASC)
)

;

CREATE TABLE `departamento`
(
	`idDepartamento` INT NOT NULL AUTO_INCREMENT,
	`nombreDepartamento` VARCHAR(50) NOT NULL,
	`longitudDepartamento` DOUBLE(10,2) NOT NULL,
	`latitudDepartamento` DOUBLE(10,2) NOT NULL,
	CONSTRAINT `PK_Departamento` PRIMARY KEY (`idDepartamento` ASC)
)

;

CREATE TABLE `logro`
(
	`idLogro` INT NOT NULL AUTO_INCREMENT,
	`nombreLogro` VARCHAR(50) NOT NULL,
	`descripcionLogro` TEXT NOT NULL,
	`insigniaLogro` VARCHAR(250) NOT NULL,
	CONSTRAINT `PK_logros` PRIMARY KEY (`idLogro` ASC)
)

;

CREATE TABLE `logroObjetivo`
(
	`idLogroObjetivo` INT NOT NULL AUTO_INCREMENT,
	`idLogro` INT NULL,
	`idObjetivo` INT NULL,
	CONSTRAINT `PK_logroObjetivo` PRIMARY KEY (`idLogroObjetivo` ASC)
)

;

CREATE TABLE `municipio`
(
	`idMunicipio` INT NOT NULL AUTO_INCREMENT,
	`nombreMunicipio` VARCHAR(50) NOT NULL,
	`longitudMunicipio` DOUBLE(10,2) NOT NULL,
	`latitudMunicipio` DOUBLE(10,2) NOT NULL,
	`idDepartamento` INT NOT NULL,
	`descripcionMunicipio` TEXT NOT NULL,
	`idInstagram` INT NOT NULL,
	CONSTRAINT `PK_municipio` PRIMARY KEY (`idMunicipio` ASC)
)

;

CREATE TABLE `objetivo`
(
	`idObjetivo` INT NOT NULL AUTO_INCREMENT,
	`nombreObjetivo` VARCHAR(50) NOT NULL,
	`descripcionObjetivo` TEXT NOT NULL,
	CONSTRAINT `PK_objetivo` PRIMARY KEY (`idObjetivo` ASC)
)

;

CREATE TABLE `ruta`
(
	`idRuta` INT NOT NULL AUTO_INCREMENT,
	`nombreRuta` VARCHAR(50) NOT NULL,
	`descripcionRuta` TEXT NOT NULL,
	`tipoRuta` INT NOT NULL,
	CONSTRAINT `PK_ruta` PRIMARY KEY (`idRuta` ASC)
)

;

CREATE TABLE `tipoRuta`
(
	`idRuta` INT NOT NULL AUTO_INCREMENT,
	`nombreTIpoRuta` VARCHAR(50) NOT NULL,
	CONSTRAINT `PK_tipoRuta` PRIMARY KEY (`idRuta` ASC)
)

;

CREATE TABLE `usuario`
(
	`idUsuario` INT NOT NULL AUTO_INCREMENT,
	`nombreUsuario` VARCHAR(50) NOT NULL,
	`apellidoUsuario` VARCHAR(50) NOT NULL,
	`correoUsuario` VARCHAR(250) NOT NULL,
	`contrasenaUsuario` VARCHAR(50) NOT NULL,
	`apodoUsuario` VARCHAR(50) NOT NULL,
	`telefonoUsuario` VARCHAR(50) NULL,
	`fotoUsuario` VARCHAR(250) NOT NULL,
	`idAvatar` INT NULL,
	CONSTRAINT `PK_Usuario` PRIMARY KEY (`idUsuario` ASC)
)

;

CREATE TABLE `usuarioLogro`
(
	`idUsuarioLogro` INT NOT NULL AUTO_INCREMENT,
	`idUsuario` INT NOT NULL,
	`estadoUsuaroLogro` BOOL NOT NULL,
	`idLogro` INT NOT NULL,
	CONSTRAINT `PK_usuarioLogro` PRIMARY KEY (`idUsuarioLogro` ASC)
)

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE `atractivo` 
 ADD INDEX `IXFK_atractivo_municipio` (`idMunicipio` ASC)
;

ALTER TABLE `atractivoRuta` 
 ADD INDEX `IXFK_atractivoRuta_atractivo` (`idAtractivo` ASC)
;

ALTER TABLE `atractivoRuta` 
 ADD INDEX `IXFK_atractivoRuta_ruta` (`idRuta` ASC)
;

ALTER TABLE `avatar` 
 ADD INDEX `IXFK_avatar_ruta` (`idRuta` ASC)
;

ALTER TABLE `logroObjetivo` 
 ADD INDEX `IXFK_logroObjetivo_logro` (`idLogro` ASC)
;

ALTER TABLE `logroObjetivo` 
 ADD INDEX `IXFK_logroObjetivo_objetivo` (`idObjetivo` ASC)
;

ALTER TABLE `municipio` 
 ADD INDEX `IXFK_municipio_Departamento` (`idDepartamento` ASC)
;

ALTER TABLE `ruta` 
 ADD INDEX `IXFK_ruta_tipoRuta` (`tipoRuta` ASC)
;

ALTER TABLE `usuario` 
 ADD INDEX `IXFK_usuario_avatar` (`idAvatar` ASC)
;

ALTER TABLE `usuarioLogro` 
 ADD INDEX `IXFK_usuarioLogro_logro` (`idLogro` ASC)
;

ALTER TABLE `usuarioLogro` 
 ADD INDEX `IXFK_usuarioLogro_usuario` (`idUsuario` ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE `atractivo` 
 ADD CONSTRAINT `FK_atractivo_municipio`
	FOREIGN KEY (`idMunicipio`) REFERENCES `municipio` (`idMunicipio`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `atractivoRuta` 
 ADD CONSTRAINT `FK_atractivoRuta_atractivo`
	FOREIGN KEY (`idAtractivo`) REFERENCES `atractivo` (`idAtractivo`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `atractivoRuta` 
 ADD CONSTRAINT `FK_atractivoRuta_ruta`
	FOREIGN KEY (`idRuta`) REFERENCES `ruta` (`idRuta`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `avatar` 
 ADD CONSTRAINT `FK_avatar_ruta`
	FOREIGN KEY (`idRuta`) REFERENCES `ruta` (`idRuta`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `logroObjetivo` 
 ADD CONSTRAINT `FK_logroObjetivo_logro`
	FOREIGN KEY (`idLogro`) REFERENCES `logro` (`idLogro`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `logroObjetivo` 
 ADD CONSTRAINT `FK_logroObjetivo_objetivo`
	FOREIGN KEY (`idObjetivo`) REFERENCES `objetivo` (`idObjetivo`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `municipio` 
 ADD CONSTRAINT `FK_municipio_Departamento`
	FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `ruta` 
 ADD CONSTRAINT `FK_ruta_tipoRuta`
	FOREIGN KEY (`tipoRuta`) REFERENCES `tipoRuta` (`idRuta`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `usuario` 
 ADD CONSTRAINT `FK_usuario_avatar`
	FOREIGN KEY (`idAvatar`) REFERENCES `avatar` (`idAvatar`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `usuarioLogro` 
 ADD CONSTRAINT `FK_usuarioLogro_logro`
	FOREIGN KEY (`idLogro`) REFERENCES `logro` (`idLogro`) ON DELETE Cascade ON UPDATE Cascade
;

ALTER TABLE `usuarioLogro` 
 ADD CONSTRAINT `FK_usuarioLogro_usuario`
	FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE Cascade ON UPDATE Cascade
;

SET FOREIGN_KEY_CHECKS=1
; 