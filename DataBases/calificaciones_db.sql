-- ============================================================
-- Sistema de Gestión de Calificaciones
-- Base de datos: calificaciones_db
-- Compatible con MySQL 8.0+
--
-- Importante:
-- Este script crea/reemplaza las tablas y carga los registros
-- incluidos en los fragmentos SQL proporcionados.
-- ============================================================

CREATE DATABASE IF NOT EXISTS calificaciones_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

USE calificaciones_db;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS calificaciones;
DROP TABLE IF EXISTS materias;
DROP TABLE IF EXISTS alumnos;

SET FOREIGN_KEY_CHECKS = 1;

-- ------------------------------------------------------------
-- Tabla: alumnos
-- ------------------------------------------------------------
CREATE TABLE alumnos (
  id_alumnos INT NOT NULL AUTO_INCREMENT,
  matricula VARCHAR(45) DEFAULT NULL,
  nombre VARCHAR(45) DEFAULT NULL,
  apellidos VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (id_alumnos)
) ENGINE=InnoDB AUTO_INCREMENT=64
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO alumnos (id_alumnos, matricula, nombre, apellidos) VALUES
(1,'A000','Enrique','Huerta Garcia'),
(2,'A001','Juan','Pérez García'),
(3,'A002','María','López Hernández'),
(4,'A003','Carlos','Ramírez Torres'),
(5,'A004','Ana','Martínez Sánchez'),
(6,'A005','Luis','González Flores'),
(7,'A006','Sofía','Hernández Ruiz'),
(8,'A007','Pedro','Torres Díaz'),
(9,'A008','Laura','Sánchez Morales'),
(10,'A009','Miguel','Ramírez López'),
(11,'A010','Valeria','García Castro'),
(12,'A011','José','Flores Mendoza'),
(13,'A012','Fernanda','Díaz Romero'),
(14,'A013','Diego','Morales Jiménez'),
(15,'A014','Daniela','Castro Vargas'),
(16,'A015','Ricardo','Ruiz Ortega'),
(17,'A016','Camila','Jiménez Reyes'),
(18,'A017','Alejandro','Vargas Silva'),
(19,'A018','Gabriela','Ortega Cruz'),
(20,'A019','Emmanuel','Reyes Navarro'),
(21,'A020','Paola','Silva Medina'),
(22,'A021','Andrés','Cruz Aguilar'),
(23,'A022','Natalia','Navarro Rojas'),
(24,'A023','Fernando','Medina León'),
(25,'A024','Regina','Aguilar Santos'),
(26,'A025','Roberto','Rojas Guerrero'),
(27,'A026','Ximena','León Herrera'),
(28,'A027','Eduardo','Santos Molina'),
(29,'A028','Isabella','Guerrero Campos'),
(30,'A029','Jorge','Herrera Salazar'),
(31,'A030','Renata','Molina Vega'),
(32,'A031','Adrián','Campos Paredes'),
(33,'A032','Lucía','Salazar Núñez'),
(34,'A033','Óscar','Vega Contreras'),
(35,'A034','Elena','Paredes Ríos'),
(36,'A035','Héctor','Núñez Valdez'),
(37,'A036','Victoria','Contreras Luna'),
(38,'A037','Manuel','Ríos Espinoza'),
(39,'A038','Andrea','Valdez Cárdenas'),
(40,'A039','Santiago','Luna Chávez'),
(41,'A040','Alexa','Espinoza Méndez'),
(42,'A041','Mateo','Domínguez Castillo'),
(43,'A042','Julieta','Acosta Méndez'),
(44,'A043','Iván','Miranda Soto'),
(45,'A044','Alejandra','Cortés Rangel'),
(46,'A045','Brandon','Salinas Peña'),
(47,'A046','Melissa','Delgado Fuentes'),
(48,'A047','Ángel','Cabrera Solís'),
(49,'A048','Valentina','Estrada Ponce'),
(50,'A049','Kevin','Ibarra Lozano'),
(51,'A050','Mariana','Campos Villanueva'),
(52,'A051','Leonardo','Maldonado Ortiz'),
(53,'A052','Diana','Castañeda Bravo'),
(54,'A053','Axel','Pacheco Robles'),
(55,'A054','Carolina','Mejía Zamora'),
(56,'A055','Gael','Bautista Valencia'),
(57,'A056','Mónica','Fuentes Carrillo'),
(58,'A057','Emilio','Nava Escobar'),
(59,'A058','Paulina','Orozco Benítez'),
(60,'A059','Sebastián','Acosta Velázquez'),
(61,'A060','Regina','Vázquez Montoya');

-- ------------------------------------------------------------
-- Tabla: materias
-- ------------------------------------------------------------
CREATE TABLE materias (
  id_materia INT NOT NULL AUTO_INCREMENT,
  clave VARCHAR(45) DEFAULT NULL,
  nombre_materia VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (id_materia)
) ENGINE=InnoDB AUTO_INCREMENT=29
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO materias (id_materia, clave, nombre_materia) VALUES
(1,'MAT001','Español'),
(2,'MAT002','Matemáticas'),
(3,'MAT003','Biología'),
(4,'MAT004','Física'),
(5,'MAT005','Química'),
(6,'MAT006','Historia de México'),
(7,'MAT007','Historia Universal'),
(8,'MAT008','Geografía'),
(9,'MAT009','Formación Cívica y Ética'),
(10,'MAT010','Inglés'),
(11,'MAT011','Educación Física'),
(12,'MAT012','Artes'),
(13,'MAT013','Tecnología'),
(14,'MAT014','Informática'),
(15,'MAT015','Tutoría'),
(16,'MAT016','Vida Saludable'),
(17,'MAT017','Lectura y Redacción'),
(18,'MAT018','Álgebra'),
(19,'MAT019','Geometría'),
(20,'MAT020','Estadística'),
(21,'MAT021','Ecología'),
(22,'MAT022','Educación Ambiental'),
(23,'MAT023','Cultura Digital'),
(24,'MAT024','Robótica'),
(25,'MAT025','Música'),
(26,'MAT026','Danza'),
(27,'MAT027','Teatro'),
(28,'MAT028','Dibujo');

-- ------------------------------------------------------------
-- Tabla: calificaciones
-- ------------------------------------------------------------
CREATE TABLE calificaciones (
  id_calificacion INT NOT NULL AUTO_INCREMENT,
  alumno_id INT DEFAULT NULL,
  materia_id INT DEFAULT NULL,
  calificacion FLOAT DEFAULT NULL,
  PRIMARY KEY (id_calificacion),
  KEY id_alumno_idx (alumno_id),
  KEY id_materia_idx (materia_id),
  CONSTRAINT id_alumno
    FOREIGN KEY (alumno_id) REFERENCES alumnos (id_alumnos),
  CONSTRAINT id_materia
    FOREIGN KEY (materia_id) REFERENCES materias (id_materia)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27724
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO calificaciones
  (id_calificacion, alumno_id, materia_id, calificacion) VALUES
(1,1,2,8),
(2,1,1,9.1),
(3,5,1,7),
(4,8,2,7.3),
(5,8,3,7.6),
(6,8,4,7.9),
(7,5,5,8.2),
(8,3,6,8.5),
(9,6,7,8.8),
(10,9,8,9.1),
(11,8,9,9.4),
(12,7,10,9.7),
(13,4,11,10),
(14,5,12,6.2),
(15,1,13,6.5),
(16,2,14,6.8),
(17,3,15,7.1),
(18,2,16,7.4),
(19,9,17,7.7),
(20,8,18,8),
(21,1,19,8.3),
(22,5,20,8.6),
(23,5,21,8.9),
(24,5,22,9.2),
(25,8,23,9.5),
(26,5,24,9.8),
(27,2,25,6),
(28,5,1,7.7),
(29,5,2,8),
(30,6,3,8.3),
(31,5,4,8.6),
(32,5,5,8.9),
(33,4,6,9.2),
(34,5,7,9.5),
(35,2,8,9.8),
(36,5,9,6),
(37,2,10,6.3),
(38,8,11,6.6),
(39,4,12,6.9),
(40,5,13,7.2),
(41,6,14,7.5),
(42,7,15,7.8),
(43,8,16,8.1),
(44,9,17,8.4),
(45,4,18,8.7),
(46,5,19,9),
(47,2,20,9.3),
(48,1,21,9.6),
(49,4,22,9.9),
(50,5,23,6.1),
(51,2,24,6.4),
(52,6,25,6.7),
(53,5,1,9.1),
(54,7,2,9.4),
(55,8,3,9.7),
(56,9,4,10),
(57,8,5,6.2),
(58,4,1,9.1),
(59,1,2,9.4),
(60,5,3,9.7),
(61,6,4,10),
(62,3,5,6.2),
(63,2,1,9.1),
(64,8,2,9.4),
(65,7,3,9.7),
(66,4,4,10),
(67,5,5,6.2),
(68,6,6,6.5),
(69,5,7,6.8),
(70,4,8,7.1),
(71,8,9,7.4),
(72,4,10,7.7),
(73,12,2,6),
(74,14,2,7.5);

-- ------------------------------------------------------------
-- Verificación rápida de la carga
-- ------------------------------------------------------------
SELECT 'alumnos' AS tabla, COUNT(*) AS registros FROM alumnos
UNION ALL
SELECT 'materias', COUNT(*) FROM materias
UNION ALL
SELECT 'calificaciones', COUNT(*) FROM calificaciones;
