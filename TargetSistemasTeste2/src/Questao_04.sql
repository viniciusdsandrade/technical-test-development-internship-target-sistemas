#  4) Banco de dados
#
#     Uma empresa solicitou a você um aplicativo para manutenção de um cadastro de clientes. Após a reunião de definição dos requisitos, as conclusões foram as seguintes:
#
#     - Um cliente pode ter um número ilimitado de telefones;
#     - Cada telefone de cliente tem um tipo, por exemplo: comercial, residencial, celular, etc. O sistema deve permitir cadastrar novos tipos de telefone;
#     - A princípio, é necessário saber apenas em qual estado brasileiro cada cliente se encontra. O sistema deve permitir cadastrar novos estados;
#
#     Você ficou responsável pela parte da estrutura de banco de dados que será usada pelo aplicativo. Assim sendo:
#
#     - Proponha um modelo lógico para o banco de dados que vai atender a aplicação. Desenhe as tabelas necessárias, os campos de cada uma e marque com setas os relacionamentos existentes entre as tabelas;
#     - Aponte os campos que são chave primária (PK) e chave estrangeira (FK);
#     - Faça uma busca utilizando comando SQL que traga o código, a razão social e o(s) telefone(s) de todos os clientes do estado de São Paulo (código “SP”);

DROP DATABASE IF EXISTS questao_04;
CREATE DATABASE IF NOT EXISTS questao_04;
USE questao_04;

-- Tabela Estado
CREATE TABLE IF NOT EXISTS tb_estado
(
    id_estado BIGINT UNSIGNED AUTO_INCREMENT,
    nome      VARCHAR(100) NOT NULL,
    sigla     CHAR(2)      NOT NULL,

    PRIMARY KEY (id_estado)
);

-- Tabela TipoTelefone
CREATE TABLE IF NOT EXISTS tb_tipo_telefone
(
    id_tipo_telefone BIGINT UNSIGNED AUTO_INCREMENT,
    descricao        VARCHAR(50) NOT NULL,

    PRIMARY KEY (id_tipo_telefone)
);

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS tb_cliente
(
    id_cliente   BIGINT UNSIGNED AUTO_INCREMENT,
    razao_social VARCHAR(255) NOT NULL,
    id_estado    BIGINT UNSIGNED,

    PRIMARY KEY (id_cliente),

    FOREIGN KEY (id_estado) REFERENCES tb_estado (id_estado)
);

-- Tabela Telefone
CREATE TABLE IF NOT EXISTS tb_telefone
(
    id_telefone      BIGINT UNSIGNED AUTO_INCREMENT,
    numero           VARCHAR(20) NOT NULL,
    id_cliente       BIGINT UNSIGNED,
    id_tipo_telefone BIGINT UNSIGNED,

    PRIMARY KEY (id_telefone),

    FOREIGN KEY (id_cliente) REFERENCES tb_cliente (id_cliente),
    FOREIGN KEY (id_tipo_telefone) REFERENCES tb_tipo_telefone (id_tipo_telefone)
);

SELECT c.id_cliente,
       c.razao_social,
       t.numero AS telefone
FROM tb_cliente c
         JOIN
     tb_estado e ON c.id_estado = e.id_estado
         JOIN
     tb_telefone t ON c.id_cliente = t.id_cliente
WHERE e.sigla = 'SP';


-- Inserir estados
INSERT INTO tb_estado (nome, sigla) VALUES ('São Paulo', 'SP');
INSERT INTO tb_estado (nome, sigla) VALUES ('Rio de Janeiro', 'RJ');

-- Inserir tipos de telefone
INSERT INTO tb_tipo_telefone (descricao) VALUES ('Comercial');
INSERT INTO tb_tipo_telefone (descricao) VALUES ('Celular');
INSERT INTO tb_tipo_telefone (descricao) VALUES ('Residencial');

-- Inserir clientes
INSERT INTO tb_cliente (razao_social, id_estado) VALUES ('Empresa X', 1);
INSERT INTO tb_cliente (razao_social, id_estado) VALUES ('Empresa Y', 2);

-- Inserir telefones
INSERT INTO tb_telefone (numero, id_cliente, id_tipo_telefone) VALUES ('(11) 99999-9999', 1, 2);
INSERT INTO tb_telefone (numero, id_cliente, id_tipo_telefone) VALUES ('(21) 88888-8888', 2, 1);
