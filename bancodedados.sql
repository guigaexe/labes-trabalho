/*DROP DATABASE bdlabes;*/
CREATE DATABASE IF NOT EXISTS bdlabes;
USE bdlabes;

CREATE TABLE usuario(
	id_usuario INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome_usuario VARCHAR(255) NOT NULL,
    apelido_usuario VARCHAR(255) UNIQUE NOT NULL,
    email_usuario VARCHAR(255),
    senha_usuario VARCHAR(255) NOT NULL,
    privilegio_usuario INT NOT NULL,
    PRIMARY KEY(id_usuario)
);
CREATE TABLE postagem(
	id_postagem INT UNSIGNED NOT NULL AUTO_INCREMENT,
    fk_postagem_usuario_apelido VARCHAR(255) NOT NULL,
    titulo_postagem VARCHAR(255) NOT NULL,
    data_postagem DATETIME NOT NULL,
    conteudo_postagem TEXT NOT NULL,
    PRIMARY KEY(id_postagem),
    FOREIGN KEY(fk_postagem_usuario_apelido) REFERENCES usuario(apelido_usuario) ON DELETE CASCADE
);

CREATE TABLE comentario(
	id_comentario INT UNSIGNED NOT NULL AUTO_INCREMENT,
    fk_comentario_postagem_id INT UNSIGNED NOT NULL,
    fk_comentario_usuario_apelido VARCHAR(255) NOT NULL,
    data_comentario DATETIME NOT NULL,
    conteudo_comentario VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_comentario),
    FOREIGN KEY(fk_comentario_postagem_id) REFERENCES postagem(id_postagem) ON DELETE CASCADE,
    FOREIGN KEY(fk_comentario_usuario_apelido) REFERENCES usuario(apelido_usuario) ON DELETE CASCADE
);
/*INSERT INTO comentario VALUES(2, 1, "Guiga", "2005-11-12", "funcina :D");
INSERT INTO comentario(fk_comentario_postagem_id, fk_comentario_usuario_apelido, data_comentario, conteudo_comentario) VALUES(?, ?, ?, ?)
SELECT id_comentario, fk_comentario_usuario_apelido, data_comentario, conteudo_comentario
FROM comentario
WHERE fk_comentario_postagem_id = 1
ORDER BY data_comentario DESC;
SELECT data_postagem FROM postagem;
SELECT * FROM postagem ORDER BY data_postagem DESC LIMIT 5;*/
INSERT INTO usuario VALUES(id_usuario, "Guilherme Eric", "Guiga", "Guilherme@uol.com.br", "123", 0);
INSERT INTO postagem VALUES(id_postagem, "Guiga", "Esta postagem vem do banco de dados", "2018-02-02", "Não acho que quem ganhar ou quem perder, nem quem ganhar nem perder, vai ganhar ou perder. Vai todo mundo perder.");
INSERT INTO postagem VALUES(id_postagem, "Guiga", "Esta postagem também vem do banco de dados", "2018-02-02", "Não acho que quem ganhar ou quem perder, nem quem ganhar nem perder, vai ganhar ou perder. Vai todo mundo perder.");
INSERT INTO postagem VALUES(id_postagem, "Guiga", "Mais uma", "2018-02-02", "Não acho que quem ganhar ou quem perder, nem quem ganhar nem perder, vai ganhar ou perder. Vai todo mundo perder.");/*
INSERT INTO usuario VALUES(2, "Geovane Santos", "Crota", "Geovane@bol.com.br", "123", 1);
INSERT INTO usuario VALUES(3, "Leonardo Costa", "GrandeLepe", "Leonardo@outlook.com", "123", 1);
INSERT INTO postagem VALUES(id_postagem, "Guiga", "Testes no banco de dados: Como fazer?", "2008-11-11", "Lorem ipsum.");/*
INSERT INTO postagem VALUES(2, 1, "Chaves estrangeiras: uma dor de cabeça", "2018-09-11", "Lorem ipsum.");
INSERT INTO comentario VALUES(1, 1, 2, "2018-09-10", "Massa!");
INSERT INTO comentario VALUES(2, 2, 2, "2018-09-11", "Tá errado isso aí.");
INSERT INTO comentario VALUES(3, 2, 3, "2018-09-11", "É osso.");*/
/*
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

 SHOW VARIABLES LIKE 'log_error';*/