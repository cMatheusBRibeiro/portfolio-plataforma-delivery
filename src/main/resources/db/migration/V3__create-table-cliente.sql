CREATE TABLE cliente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(100) NULL,
    ativo TINYINT(1) NOT NULL,
    CONSTRAINT pk_cliente_id
        PRIMARY KEY (id),
    CONSTRAINT unq_cliente_login
        UNIQUE (login),
    CONSTRAINT unq_cliente_email
        UNIQUE (email),
    CONSTRAINT unq_cliente_telefone
        UNIQUE (telefone)
)ENGINE=INNODB;