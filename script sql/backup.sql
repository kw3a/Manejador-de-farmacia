-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-05-2022 a las 00:51:12
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

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`ID_MEDICAMENTO`, `NOMBRE_MEDICAMENTO`, `CONTENIDO`, `UNIDADES_CONTENIDO`, `MARCA`, `PRECIO`, `STOCK`) VALUES
(1, 'ibuprofeno', 100, 'mg', 'bago', 4, 200);

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`ID_PEDIDO`, `ID_MEDICAMENTO`, `EMPRESA`, `FECHA_PEDIDO`, `CANTIDAD_COMPRADA`, `PRECIOUNITARIO`, `PRECIOTOTAL`, `FECHA_VENCIMIENTO`) VALUES
('123', 1, 'bago', '2022-05-02', 1, 5.00, 5.00, '2021-05-03');

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`EMPRESA`, `NOMBRE_REPRESENTANTE`, `DOMICILIO`, `TELEFONO`) VALUES
('bago', 'carlos', 'Blanco Galindo Km 5', '69552000');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
