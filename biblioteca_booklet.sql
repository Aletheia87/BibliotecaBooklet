CREATE DATABASE biblioteca_booklet;

USE biblioteca_booklet;

CREATE TABLE libro (
id INT auto_increment not null primary key,
titulo VARCHAR(200),
anio INT,
autor VARCHAR(100),
imprenta VARCHAR(100),
disponible BOOLEAN
);

Select *
From libro;