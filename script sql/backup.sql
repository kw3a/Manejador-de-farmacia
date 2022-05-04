-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2022 a las 05:58:32
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
('10405984', 'Miranda Mamani', 0),
('123', 'pedro', 0),
('13458920', 'Juan Soliz', 0),
('15489654', 'Carla Serrano', 0),
('18475692', 'Oscar Lopez', 0);

--
-- Volcado de datos para la tabla `desechado`
--

INSERT INTO `desechado` (`ID_MEDICAMENTO`, `FECHA_DESECHO`, `CANTIDAD_DESECHADA`, `TOTAL_PERDIDO`, `MOTIVO_DESECHO`) VALUES
(2, '2022-05-02', 3, 30.00, 'se ha caido'),
(1, '2022-05-02', 3, 12.00, 'vencido'),
(3, '2022-05-02', 7, 70.00, 'no tiene registro sanitario'),
(4, '2022-05-03', 20, 20.00, 'defectuoso'),
(5, '2022-05-03', 4, 8.00, 'dañados');

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`ID_MEDICAMENTO`, `NOMBRE_MEDICAMENTO`, `CONTENIDO`, `UNIDADES_CONTENIDO`, `MARCA`, `PRECIO`, `STOCK`) VALUES
(1, 'ibuprofeno', 100, 'mg', 'bago', 4, 6),
(2, 'paracetamol', 200, 'g', 'bago', 5, 193),
(3, 'omeprazol', 100, 'mg', 'inti', 10, 188),
(4, 'aspirina', 300, 'mg', 'cofar', 1, 276),
(5, 'omeprazol', 30, 'mg', 'sanafarma', 2, 196),
(6, 'metronillazol', 250, 'mg', 'tecnofarma', 1, 400);

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`ID_PEDIDO`, `ID_MEDICAMENTO`, `EMPRESA`, `FECHA_PEDIDO`, `CANTIDAD_COMPRADA`, `PRECIO_UNITARIO`, `PRECIO_TOTAL`, `FECHA_VENCIMIENTO`) VALUES
(123, 1, 'bago', '2022-05-02', 1, 5.00, 5.00, '2021-05-13'),
(128, 3, 'bago', '2022-05-02', 20, 3.00, 60.00, '2022-03-09'),
(130, 3, 'sanafarma', '2022-05-03', 100, 1.00, 100.00, '2022-05-31'),
(131, 1, 'tecnofarma', '2022-05-03', 10, 5.00, 50.00, '2022-03-16'),
(132, 5, 'tecnofarma', '2022-05-03', 50, 2.00, 100.00, '2022-05-27'),
(134, 4, 'sanafarma', '2022-05-03', 2, 3.00, 6.00, '2022-06-01');

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`EMPRESA`, `NOMBRE_REPRESENTANTE`, `DOMICILIO`, `TELEFONO`) VALUES
('bago', 'carlos', 'Blanco Galindo Km 5', '69552000'),
('laboratorio infarma', 'juan', 'calle bolivar', '44665577'),
('sanafarma', 'Darwin Ledezma', 'Av oquendo', '69451025'),
('tecnofarma', 'juan perez', 'calla lanza', '75329610');

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`CI_VEN`, `NOMBRE_VEN`, `PUESTO`) VALUES
('124', 'juan', 'vendedor'),
('13533478', 'Aldair Torrez', 'cajero'),
('8787874', 'Emanuel Peredo', 'cajero');

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`ID_VENTA`, `CI_VEN`, `CI_CLI`, `TOTAL`, `FECHA_VENTA`) VALUES
(2, '124', '123', 4.00, '2022-05-02'),
(3, '124', '123', 20.00, '2022-05-02'),
(4, '124', '123', 16.00, '2022-05-02'),
(5, '124', '123', 4.00, '2022-05-02'),
(6, '124', '123', 30.00, '2022-05-02'),
(7, '124', '123', 20.00, '2022-05-02'),
(8, '124', '123', 4.00, '2022-05-03'),
(9, '124', '123', 20.00, '2022-05-03');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
