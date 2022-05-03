-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-05-2022 a las 06:03:45
-- Versión del servidor: 10.6.3-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `farmacia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `CI_CLI` char(8) NOT NULL,
  `NOMBRE_CLI` char(255) DEFAULT NULL,
  `PUNTOS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contiene`
--

CREATE TABLE `contiene` (
  `ID_MEDICAMENTO` int(11) NOT NULL,
  `ID_VENTA` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desechado`
--

CREATE TABLE `desechado` (
  `ID_MEDICAMENTO` int(11) DEFAULT NULL,
  `FECHA_DESECHO` date DEFAULT current_timestamp(),
  `CANTIDAD_DESECHADA` int(11) DEFAULT NULL,
  `TOTAL_PERDIDO` float(8,2) DEFAULT NULL,
  `MOTIVO_DESECHO` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `ID_MEDICAMENTO` int(11) NOT NULL,
  `NOMBRE_MEDICAMENTO` char(255) DEFAULT NULL,
  `CONTENIDO` int(11) DEFAULT NULL,
  `UNIDADES_CONTENIDO` char(255) DEFAULT NULL,
  `MARCA` char(255) DEFAULT NULL,
  `PRECIO` float(8,0) DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `ID_PEDIDO` int(255) NOT NULL,
  `ID_MEDICAMENTO` int(11) DEFAULT NULL,
  `EMPRESA` char(255) DEFAULT NULL,
  `FECHA_PEDIDO` date DEFAULT current_timestamp(),
  `CANTIDAD_COMPRADA` int(11) DEFAULT NULL,
  `PRECIO_UNITARIO` float(8,2) DEFAULT NULL,
  `PRECIO_TOTAL` float(8,2) DEFAULT NULL,
  `FECHA_VENCIMIENTO` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `EMPRESA` char(255) NOT NULL,
  `NOMBRE_REPRESENTANTE` char(255) DEFAULT NULL,
  `DOMICILIO` char(255) DEFAULT NULL,
  `TELEFONO` char(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `CI_VEN` char(8) NOT NULL,
  `NOMBRE_VEN` char(255) DEFAULT NULL,
  `PUESTO` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `ID_VENTA` int(255) NOT NULL,
  `CI_VEN` char(8) DEFAULT NULL,
  `CI_CLI` char(8) DEFAULT NULL,
  `TOTAL` float(8,2) DEFAULT NULL,
  `FECHA_VENTA` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CI_CLI`);

--
-- Indices de la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`ID_MEDICAMENTO`,`ID_VENTA`),
  ADD KEY `FK_CONTIENE2` (`ID_VENTA`);

--
-- Indices de la tabla `desechado`
--
ALTER TABLE `desechado`
  ADD KEY `FK_RELATIONSHIP_7` (`ID_MEDICAMENTO`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`ID_MEDICAMENTO`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`ID_PEDIDO`),
  ADD KEY `FK_RELATIONSHIP_5` (`ID_MEDICAMENTO`),
  ADD KEY `FK_RELATIONSHIP_6` (`EMPRESA`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`EMPRESA`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`CI_VEN`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`ID_VENTA`),
  ADD KEY `FK_COMPRA` (`CI_CLI`),
  ADD KEY `FK_VENDE` (`CI_VEN`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `ID_MEDICAMENTO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `ID_PEDIDO` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `ID_VENTA` int(255) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD CONSTRAINT `FK_CONTIENE` FOREIGN KEY (`ID_MEDICAMENTO`) REFERENCES `medicamento` (`ID_MEDICAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CONTIENE2` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `desechado`
--
ALTER TABLE `desechado`
  ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`ID_MEDICAMENTO`) REFERENCES `medicamento` (`ID_MEDICAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`ID_MEDICAMENTO`) REFERENCES `medicamento` (`ID_MEDICAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`EMPRESA`) REFERENCES `proveedor` (`EMPRESA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_COMPRA` FOREIGN KEY (`CI_CLI`) REFERENCES `cliente` (`CI_CLI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_VENDE` FOREIGN KEY (`CI_VEN`) REFERENCES `vendedor` (`CI_VEN`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
