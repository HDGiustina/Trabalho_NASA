Scriptjhonson sql:

-- drop database bancoTrabalhoPa; 
create database bancoTrabalhoPa; 
use bancoTrabalhoPa;

CREATE TABLE IF NOT EXISTS Asteroides ( date DATE, id VARCHAR(255), id_neo_referencia VARCHAR(255), nome VARCHAR(255), data_aproximacao_maxima DATE, velocidade_relativa_em_kms DOUBLE, distancia_min_da_terra_em_km DOUBLE, diametro_estimado_em_km DOUBLE, corpo_orbitante VARCHAR(255), potencialmente_perigoso BOOL, nivel_ameaca VARCHAR(255), PRIMARY KEY (id, date) );
CREATE TABLE configuracoes ( id int AUTO_INCREMENT PRIMARY KEY, periodo_grafico VARCHAR(3) NOT NULL );
INSERT INTO configuracoes (periodo_grafico) VALUES ('mes');

-- ordenacao
CREATE TABLE opcoesDeOrdenacao ( id INT AUTO_INCREMENT PRIMARY KEY, ordenacao VARCHAR(255) NOT NULL, texto VARCHAR(255) NOT NULL );
INSERT INTO opcoesDeOrdenacao (ordenacao, texto) VALUES
    ('diametro_estimado_em_km', 'Diâmetro estimado'),
    ('distancia_min_da_terra_em_km', 'Distância Mínima'),
    ('data_aproximacao_maxima', 'Data De Aproximação'),
    ('nivel_ameaca', 'Nível de Ameaça'),
    ('nome', 'Nome'),
    ('potencialmente_perigoso', 'Perigoso'),
    ('velocidade_relativa_em_kms', 'Velocidade relativa');

    

select * from asteroides; 
select * from configuracoes;
SELECT * FROM opcoesDeOrdenacao;





