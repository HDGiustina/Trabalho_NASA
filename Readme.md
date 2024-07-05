create database bancoTrabalhoPa;
use bancoTrabalhoPa;

CREATE TABLE opcoesDeOrdenacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ordenacao VARCHAR(255) NOT NULL
);

INSERT INTO opcoesDeOrdenacao (ordenacao) VALUES
('distanciaDaTerra'),
('potencialRisco'),
('velocidadeKmHr'),
('tamanhoDoAsteroide');
