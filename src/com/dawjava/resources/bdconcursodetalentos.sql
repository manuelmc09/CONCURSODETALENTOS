SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdconcursodetalentos`
--
CREATE DATABASE IF NOT EXISTS `bdconcursodetalentos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdconcursodetalentos`;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `candidatos`
--
DROP TABLE IF EXISTS `candidatos`;
CREATE TABLE IF NOT EXISTS `candidatos` (
`idcandidato` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) NOT NULL,
`ciudad` varchar(50) NOT NULL,
`fechainscripcion` date NOT NULL,
`finalista` tinyint(1),
PRIMARY KEY (`idcandidato`),
UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Estructura de tabla para la tabla `personas`
--
DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
`idpersona` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) NOT NULL,
`email` varchar(50) NOT NULL,
`dni` varchar(9) NOT NULL,
`telefono` varchar(30),
PRIMARY KEY (`idpersona`),
UNIQUE KEY `email` (`email`),
UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Estructura de tabla para la tabla `individuales`
--
DROP TABLE IF EXISTS `individuales`;
CREATE TABLE IF NOT EXISTS `individuales` (
`idcandidato` int(11) NOT NULL,
`edad` int(11) NOT NULL,
`idpersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indices de la tabla `individuales`
--
ALTER TABLE `individuales`
ADD PRIMARY KEY (`idcandidato`),
ADD KEY `FK_PERSONA` (`idpersona`),
ADD KEY `FK_CANDIDATO` (`idcandidato`);

--
-- Filtros para la tabla `individuales`
--
ALTER TABLE `individuales`
ADD CONSTRAINT `FK_CANDIDATO` FOREIGN KEY (`idcandidato`) REFERENCES `candidatos` (`idcandidato`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_PERSONA` FOREIGN KEY (`idpersona`) REFERENCES `personas` (`idpersona`);

--
-- Estructura de tabla para la tabla `componentesgrupo`
--
DROP TABLE IF EXISTS `componentesgrupo`;
CREATE TABLE IF NOT EXISTS `componentesgrupo` (
`idpersona` int(11) NOT NULL,
`idcandidato` int(11) NOT NULL,
PRIMARY KEY (`idpersona`,`idcandidato`),
KEY `FK_GRUPO` (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



--
-- Estructura de tabla para la tabla `grupo`
--
DROP TABLE IF EXISTS `grupo`;
CREATE TABLE IF NOT EXISTS `grupo`(
`idcandidato` int(11) NOT NULL,
`idportavoz` int(11) NOT NULL,
PRIMARY KEY (`idcandidato`),
KEY `FK_COMPONENTES` (`idportavoz`),
KEY `FK_CANDIDATO` (`idcandidato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Restricciones para tabla `grupo`
--
-- ALTER TABLE `grupo`
-- ADD CONSTRAINT `FK_CANDIDATO` FOREIGN KEY (`idcandidato`) REFERENCES `candidatos` (`idcandidato`) ON DELETE CASCADE ON UPDATE CASCADE;
-- ME DA ERROR AL REFERENCIAR ESTA CLAVE AJENA :DUPLICATE FOREIGN KEY CONSTRAINT NAME `FK_CANDIDATO`
ALTER TABLE `grupo`
ADD CONSTRAINT `FK_COMPONENTES` FOREIGN KEY (`idportavoz`) REFERENCES `componentesgrupo` (`idpersona`);

--
-- Filtros para la tabla `componentesgrupo`
-- 
--
ALTER TABLE `componentesgrupo`
  ADD CONSTRAINT `FK_GRUPO` FOREIGN KEY (`idpersona`) REFERENCES `personas` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  ALTER TABLE `componentesgrupo`
  ADD CONSTRAINT `FK_CANDIDATOS` FOREIGN KEY (`idcandidato`) REFERENCES `candidatos` (`idcandidato`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  
--
-- Estructura de tabla para la tabla `convocatoria`
--
DROP TABLE IF EXISTS `convocatoria`;
CREATE TABLE IF NOT EXISTS `convocatoria`(
`idconvocatoria` int(11) NOT NULL,
`fecha` date NOT NULL,
`lugar` varchar(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indices de la tabla `convocatoria`
--
ALTER TABLE `convocatoria`
ADD PRIMARY KEY (`idconvocatoria`);

--
-- AUTO_INCREMENT de la tabla `convocatoria`
--
ALTER TABLE `convocatoria`
MODIFY `idconvocatoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- Estructura de tabla para la tabla `categoria`
--
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
`idcategoria` int(11) NOT NULL,
`categoria` varchar(50) NOT NULL,
PRIMARY KEY (`idcategoria`),
UNIQUE KEY `categoria` (`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- AUTO_INCREMENT de la tabla categoria
--
ALTER TABLE `categoria`
MODIFY `idcategoria` int(11) NOT NULL AUTO_INCREMENT;



--
-- Estructura de tabla para la tabla `jueces`
--
DROP TABLE IF EXISTS `jueces`;
CREATE TABLE IF NOT EXISTS `jueces`(
`idtribunal` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(50) NOT NULL,
`email` varchar(50) NOT NULL,
`dni` varchar(9) NOT NULL,
`telefono` varchar(30),
PRIMARY KEY (`idtribunal`),
UNIQUE KEY `email` (`email`),
UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Estructura de tabla para la tabla `audicion`
--
DROP TABLE IF EXISTS `audicion`;
CREATE TABLE IF NOT EXISTS `audicion`(
`idaudicion` int(11) NOT NULL,
`puntuacionmedia` float DEFAULT 0.0,
`lugar` varchar(50),
`fechahora` datetime,
`idcandidato` int(11) NOT NULL,
`idcategoria` int(11) NOT NULL,
`idconvocatoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indices de la tabla `audicion`
--
ALTER TABLE `audicion`
ADD PRIMARY KEY (`idaudicion`),
ADD KEY `FK_CANDIDATO` (`idcandidato`),
ADD KEY `FK_CATEGORIA` (`idcategoria`),
ADD KEY `FK_CONVOCATORIA` (`idconvocatoria`);

--
-- AUTO_INCREMENT de la tabla `audicion`
--
ALTER TABLE `audicion`
  MODIFY `idaudicion` int(11) NOT NULL AUTO_INCREMENT;
  
--
-- Restricciones para tabla  `audicion`
--
ALTER TABLE `audicion`
ADD CONSTRAINT `FK_CATEGORIA` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE `audicion`
ADD CONSTRAINT `FK_CONVOCATORIA` FOREIGN KEY (`idconvocatoria`) REFERENCES `convocatoria` (`idconvocatoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Estructura de tabla para la tabla `puntuacion`
--
DROP TABLE IF EXISTS `puntuacion`;
CREATE TABLE IF NOT EXISTS `puntuacion` (
`idtribunal` int(11) NOT NULL,
`idaudicion` int(11) NOT NULL,
`puntuacion` int(11) DEFAULT NULL,
`especial` tinyint(1) NOT NULL,
PRIMARY KEY (`idtribunal`,`idaudicion`),
KEY `FK_TRIBUNAL` (`idtribunal`)
) ENGINE=InnoDB DEFAULT CHARSET= utf8mb4;


--
-- Filtros para la tabla `puntuacion`
--
ALTER TABLE `puntuacion`
ADD CONSTRAINT `FK_TRIBUNAL` FOREIGN KEY (`idtribunal`) REFERENCES `jueces` (`idtribunal`),
ADD CONSTRAINT `FK_AUDICION` FOREIGN KEY (`idaudicion`) REFERENCES `audicion` (`idaudicion`);



--
-- Volcado de datos para la tabla `personas`
--
INSERT INTO `personas` (`idpersona`, `nombre`,`email`,`dni`,`telefono`) VALUES
(1,'Alberto García Solís','agarciasolis@gmail.com','12345687O','985235432'),
(2,'Carlos Muela','carlosmuela@gmail.com', '12993744E', '652136162'),
(3,'Francisco Fernandez','ffer@gmail.com', '26644224H', '923723221' ),
(4,'Jose Aguilas','jaguilas@gmail.com', '45737732S', '923904332' ),
(5,'Antonio Orozco','noteconozco@gmail.com','78456322H','923796021'),
(6,'Amparo Rivadalles','rivamparo@gmail.com','10891555L','942564533'),
(7,'Elena Garcia Santos','esantos@gmail.com','78432122W','622390949'),
(8,'Sheila Madariaga Urruti','sheilaurruti@gmail.com','10234543D','648796001'),
(9,'Sergio Sil Menendez','sergiosil@gmail.com','55710992K','923900121'),
(10,'Silvia Jurado Argüelles','ssjurado@gmail.com','27119363D','942456212');

--
-- Volcado de datos para la tabla `candidatos`
--
INSERT INTO `candidatos` (`idcandidato`,`nombre`,`ciudad`,`fechainscripcion`,`finalista`) VALUES
(1,'Antonio Orozco','Salamanca','2021-01-14',b'0'),
(2,'Amparo Rivadalles','CastroUrdiales','2021-02-03',b'0');
INSERT INTO `candidatos` (`idcandidato`,`nombre`,`ciudad`,`fechainscripcion`,`finalista`) VALUES
(3,'ASINCOPADOS','Zaragoza','2021-03-18',b'0');

--
-- Volcado de datos para la tabla `individuales`
--
INSERT INTO `individuales`(`idcandidato`,`edad`,`idpersona`) VALUES
(1,34,5),
(2,23,6);

--
-- Volcado de datos para la tabla `componentesgrupo`
--
INSERT INTO `componentesgrupo` (`idpersona`,`idcandidato`) VALUES
(8,3),
(9,3),
(10,3);
--
-- Volcado de datos para la tabla `grupo`
--
INSERT INTO `grupo`(`idcandidato`,`idportavoz`) VALUES
(3,8);

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idcategoria`,`categoria`) VALUES
(1,'MUSICA'),
(2,'BAILE'),
(3,'VARIEDADES');

--
-- Volcado de datos para la tabla `convocatoria`
--
INSERT INTO `convocatoria` (`idconvocatoria`,`fecha`,`lugar`) VALUES
(1,'2021-06-01','GIJON'),
(2,'2021-06-01','SANTANDER'),
(3,'2021-06-01','BILBAO'),
(4,'2021-06-01','MADRID'),
(5,'2021-06-01','VALENCIA'),
(6,'2021-06-01','SEVILLA'),
(7,'2021-06-01','CADIZ'),
(8,'2021-07-01','GIJON'),
(9,'2021-07-01','SANTANDER'),
(10,'2021-07-01','BILBAO'),
(11,'2021-07-01','MADRID'),
(12,'2021-07-01','VALENCIA'),
(13,'2021-09-01','BILBAO'),
(14,'2021-09-01','MADRID'),
(15,'2021-09-01','VALENCIA'),
(16,'2021-07-01','SEVILLA');

--
-- Volcado de datos para la tabla `jueces`
--
INSERT INTO `jueces` (`idtribunal`,`nombre`,`email`,`dni`,`telefono`) VALUES
(1,'Soledad Gimenez Satustregui','solegimenez@gmail.com','10894565T','934321201'),
(2,'Vladimir Petrov Magomedov','vladpetrov@gmail.com','53421344J','986234567'),
(3,'Rafael Benitez Martinez','rafabenitez@gmail.com','78934510L','956221230'),
(4,'Alvaro Iglesias García','alvaglesias@gmail.com','10833201N','985673245'),
(5,'Maria Gimena Santos Müller','gimenamüller@gmail.com','78543211H','947856422'),
(6,'Dolores Jimenez Ortiz','djortiz@gmail.com','10234543G','955623213'),
(7,'Lucia Chacón Andrade','lucichacon@gmail.com','53456129P','955120693');


--
-- Volcado de datos para la tabla `audicion`
--
--
INSERT INTO `audicion`(`idaudicion`,`puntuacionmedia`,`lugar`,`fechahora`,`idcandidato`,`idcategoria`,`idconvocatoria`) VALUES
(1,0.0,'Teatro Jovellanos','2021-06-01 10:00:00',1,1,1),
(2,0.0,'Palacio de Festivales Cantabria','2021-06-01 10:00:00',2,1,2),
(3,0.0,'Palacio Euskalduna','2021-06-01 10:00:00',3,1,3);

--
-- Volcado de datos para la tabla `puntuacion`
--
--
INSERT INTO `puntuacion` (`idtribunal`,`idaudicion`,`puntuacion`,`especial`) VALUES
(1,1,4,b'0'),
(2,1,6,b'0'),
(3,1,6,b'0');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;