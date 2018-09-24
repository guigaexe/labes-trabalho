DROP DATABASE bdlabes;
CREATE DATABASE IF NOT EXISTS bdlabes;
USE bdlabes;

CREATE TABLE usuario(
	id_usuario INT UNSIGNED NOT NULL,
    nome_usuario VARCHAR(255) NOT NULL,
    apelido_usuario VARCHAR(255) NOT NULL,
    email_usuario VARCHAR(255),
    senha_usuario VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_usuario)
);

CREATE TABLE postagem(
	id_postagem INT UNSIGNED NOT NULL,
    fk_postagem_usuario_id INT UNSIGNED NOT NULL,
    titulo_postagem VARCHAR(255) NOT NULL,
    data_postagem DATE NOT NULL,
    conteudo_postagem TEXT NOT NULL,
    PRIMARY KEY(id_postagem),
    FOREIGN KEY(fk_postagem_usuario_id) REFERENCES usuario(id_usuario)
);

CREATE TABLE comentario(
	id_comentario INT UNSIGNED NOT NULL,
    fk_comentario_postagem_id INT UNSIGNED NOT NULL,
    fk_comentario_usuario_id INT UNSIGNED NOT NULL,
    data_comentario DATE NOT NULL,
    conteudo_comentario VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_comentario),
    FOREIGN KEY(fk_comentario_postagem_id) REFERENCES postagem(id_postagem),
    FOREIGN KEY(fk_comentario_usuario_id) REFERENCES usuario(id_usuario)
);

INSERT INTO usuario VALUES(1, "Guilherme Eric", "Guiga", "Guilherme@uol.com.br", "123");
INSERT INTO usuario VALUES(2, "Geovane Santos", "Crota", "Geovane@bol.com.br", "123");
INSERT INTO usuario VALUES(3, "Leonardo Costa", "GrandeLepe", "Leonardo@outlook.com", "123");
INSERT INTO postagem VALUES(1, 1, "Testes no banco de dados: Como fazer?", "2018-09-10", "Lorem ipsum.");
INSERT INTO postagem VALUES(2, 1, "Chaves estrangeiras: uma dor de cabeça", "2018-09-11", "Lorem ipsum.");
INSERT INTO comentario VALUES(1, 1, 2, "2018-09-10", "Massa!");
INSERT INTO comentario VALUES(2, 2, 2, "2018-09-11", "Tá errado isso aí.");
INSERT INTO comentario VALUES(3, 2, 3, "2018-09-11", "É osso.");

SELECT * FROM usuario;
SELECT * FROM postagem;
SELECT * FROM comentario;

SELECT u.apelido_usuario, p.titulo_postagem, p.data_postagem, p.conteudo_postagem
FROM usuario u
INNER JOIN postagem p
ON u.id_usuario = p.fk_postagem_usuario_id
WHERE p.id_postagem = 1;

SELECT u.apelido_usuario, c.data_comentario, c.conteudo_comentario
FROM usuario u
INNER JOIN comentario c
ON u.id_usuario = c.fk_comentario_usuario_id
INNER JOIN postagem p
ON c.fk_comentario_postagem_id = p.id_postagem
WHERE p.id_postagem = 2;

SELECT u.apelido_usuario AS AUTOR, p.titulo_postagem AS TITULO, p.data_postagem AS DATA_POSTAGEM, p.conteudo_postagem AS ARTIGO, u1.apelido_usuario AS COMENTARISTA, c.data_comentario AS DATA_COMENTARIO, c.conteudo_comentario AS COMENTARIO
FROM postagem p
JOIN usuario u
ON u.id_usuario = p.fk_postagem_usuario_id
JOIN comentario c
ON c.fk_comentario_postagem_id = p.id_postagem
JOIN usuario u1
ON u1.id_usuario = c.fk_comentario_usuario_id;
