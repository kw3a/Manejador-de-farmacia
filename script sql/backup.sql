-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-05-2022 a las 06:04:05
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
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`CI_CLI`, `NOMBRE_CLI`, `PUNTOS`) VALUES
('123', 'pedro', 0);

--
-- Volcado de datos para la tabla `desechado`
--

INSERT INTO `desechado` (`ID_MEDICAMENTO`, `FECHA_DESECHO`, `CANTIDAD_DESECHADA`, `TOTAL_PERDIDO`, `MOTIVO_DESECHO`) VALUES
(2, '2022-05-02', 3, 30.00, 'se ha caido'),
(1, '2022-05-02', 3, 12.00, 'si'),
(3, '2022-05-02', 7, 70.00, 'no');

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`ID_MEDICAMENTO`, `NOMBRE_MEDICAMENTO`, `CONTENIDO`, `UNIDADES_CONTENIDO`, `MARCA`, `PRECIO`, `STOCK`) VALUES
(1, 'ibuprofeno', 100, 'mg', 'bago', 4, 6),
(2, 'paracetamol', 200, 'g', 'bago', 10, 193),
(3, 'omeprazol', 100, 'mg', 'inti', 10, 190);

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`ID_PEDIDO`, `ID_MEDICAMENTO`, `EMPRESA`, `FECHA_PEDIDO`, `CANTIDAD_COMPRADA`, `PRECIO_UNITARIO`, `PRECIO_TOTAL`, `FECHA_VENCIMIENTO`) VALUES
(123, 1, 'bago', '2022-05-02', 1, 5.00, 5.00, '2021-05-03'),
(124, 2, 'bago', '2022-05-02', 20, 10.00, 200.00, '2022-05-01'),
(126, 1, 'zzz', '2022-05-02', 1, 10.00, 10.00, NULL),
(127, 2, 'bago', '2022-05-02', 1, 3.00, 3.00, NULL),
(128, 3, 'bago', '2022-05-02', 20, 3.00, 60.00, '2022-03-09'),
(129, 3, 'zzz', '2022-05-02', 20, 3.00, 60.00, '2022-01-13');

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`EMPRESA`, `NOMBRE_REPRESENTANTE`, `DOMICILIO`, `TELEFONO`) VALUES
('bago', 'carlos', 'Blanco Galindo Km 5', '69552000'),
('zzz', 'juan', 'calle bolivar', '44665577');

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`CI_VEN`, `NOMBRE_VEN`, `PUESTO`) VALUES
('124', 'juan', 'vendedor');

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`ID_VENTA`, `CI_VEN`, `CI_CLI`, `TOTAL`, `FECHA_VENTA`) VALUES
(2, '124', '123', 4.00, '2022-05-02'),
(3, '124', '123', 20.00, '2022-05-02'),
(4, '124', '123', 16.00, '2022-05-02'),
(5, '124', '123', 4.00, '2022-05-02'),
(6, '124', '123', 30.00, '2022-05-02'),
(7, '124', '123', 20.00, '2022-05-02');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
