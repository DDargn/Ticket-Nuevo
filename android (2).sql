-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-04-2024 a las 08:06:38
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `android`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `fk_iduser` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `text` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tasks`
--

INSERT INTO `tasks` (`id`, `fk_iduser`, `title`, `text`, `type`, `Date`) VALUES
(1, 6, 'Hola prueba', 'este es el task de prueba', 2, '0000-00-00'),
(2, 6, 'Hola prueba', 'este es el task de prueba', 2, '0000-00-00'),
(6, 6, 'Master prueba', 'soy el master', 0, '0000-00-00'),
(7, 6, 'Master prueba', 'soy el master', 0, '0000-00-00'),
(8, 3, 'tarea asignada', 'Hola soy la tarea asignada', 1, '0000-00-00'),
(9, 3, 'tarea aceptada', 'hola soy la tarea aceptada', 2, '0000-00-00'),
(10, 3, 'tarea asignada', 'Hola soy la tarea asignada', 1, '0000-00-00'),
(11, 3, 'tarea aceptada', 'hola soy la tarea aceptada', 2, '0000-00-00'),
(12, 6, 'hola', 'holamundo\r\n\r\n\r\n\r\nhola', 0, '0000-00-00'),
(13, 6, 'hola', 'holamundo\r\n\r\n\r\n\r\nhola', 0, '0000-00-00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` text NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`) VALUES
(2, 'ivan1', '81dc9bdb52d04dc20036dbd8313ed055', 'ivan1@gmail.com'),
(3, 'prueba', 'd93591bdf7860e1e4ee2fca799911215', 'prueba@gmail.com'),
(4, 'prueba2', 'd93591bdf7860e1e4ee2fca799911215', 'prueba2@gmail.com'),
(5, 'master', '1234', 'master@gmail.com'),
(6, 'master', '1234', 'master@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_iduser` (`fk_iduser`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `fk_iduser` FOREIGN KEY (`fk_iduser`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
