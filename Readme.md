create database bancoTrabalhoPa;
use bancoTrabalhoPa;

CREATE TABLE Asteroides (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    distanciaDaTerra FLOAT NOT NULL,
    potencialRisco boolean NOT NULL,
    velocidadeKmHr FLOAT NOT NULL,
    tamanhoDoAsteroide FLOAT NOT NULL
);