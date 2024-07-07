Scriptjhonson sql:

-- drop database bancoTrabalhoPa; create database bancoTrabalhoPa; use bancoTrabalhoPa;

CREATE TABLE IF NOT EXISTS Asteroides ( date DATE, id VARCHAR(255), id_neo_referencia VARCHAR(255), nome VARCHAR(255), data_aproximacao_maxima DATE, velocidade_relativa_em_kms DOUBLE, distancia_min_da_terra_em_km DOUBLE, diametro_estimado_em_km DOUBLE, corpo_orbitante VARCHAR(255), potencialmente_perigoso BOOL, nivel_ameaca VARCHAR(255), PRIMARY KEY (id, date) );

CREATE TABLE opcoesDeOrdenacaoEFiltro ( id INT AUTO_INCREMENT PRIMARY KEY, ordenacao VARCHAR(255) NOT NULL, texto VARCHAR(255) NOT NULL );

CREATE TABLE configuracoes ( id int AUTO_INCREMENT PRIMARY KEY, periodo_grafico VARCHAR(3) NOT NULL );

INSERT INTO configuracoes (periodo_grafico) VALUES ('mes');

INSERT INTO opcoesDeOrdenacaoEFiltro (ordenacao, texto) VALUES ('distancia_min_da_terra_em_km', 'Distância Mínima'), 
('potencialmente_perigoso', 'Perigoso'), 
('velocidade_relativa_em_kms', 'Velocidade relativa'), 
('diametro_estimado_em_km', 'Diâmetro estimado');

select * from asteroides; 
select * from opcoesdeordenacaoEFiltro; 
select * from configuracoes;
SELECT * FROM opcoesDeOrdenacao;





