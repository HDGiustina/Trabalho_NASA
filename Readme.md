Scriptjhonson sql:

create database bancoTrabalhoPa;
use bancoTrabalhoPa;

CREATE TABLE IF NOT EXISTS Asteroides (
	date DATE, 
	id VARCHAR(255), 
	id_neo_referencia VARCHAR(255), 
	nome VARCHAR(255), 
	data_aproximacao_maxima DATE, 
	velocidade_relativa_em_kms DOUBLE, 
	distancia_min_da_terra_em_km DOUBLE, 
	diametro_estimado_em_km DOUBLE, 
	corpo_orbitante VARCHAR(255), 
	potencialmente_perigoso BOOL, 
	nivel_ameaca VARCHAR(255), 
	PRIMARY KEY (id, date)
);

CREATE TABLE opcoesDeOrdenacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ordenacao VARCHAR(255) NOT NULL
);

CREATE TABLE configuracoes (
	id int AUTO_INCREMENT PRIMARY KEY,
    nomeBanco VARCHAR(50) NOT NULL,
    chaveApi VARCHAR(200) NOT NULL
);


INSERT INTO configuracoes (nomeBanco, chaveApi)
VALUES ('bancotrabalhopa', 'c7rNf6fd2psQW282XAHRMjSyhlUZtpkHWbHd5k1K');


INSERT INTO opcoesDeOrdenacao (ordenacao) VALUES
('distancia_min_da_terra_em_km'),
('potencialmente_perigoso'),
('velocidade_relativa_em_kms'),
('diametro_estimado_em_km');

select * from asteroides;
select * from opcoesdeordenacao;
select * from configuracoes;




