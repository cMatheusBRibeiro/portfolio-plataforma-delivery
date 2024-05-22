CREATE TABLE funcionario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    ativo TINYINT(1) NOT NULL,
    CONSTRAINT pk_funcionario_id
        PRIMARY KEY (id),
    CONSTRAINT unq_funcionario_login
        UNIQUE (login),
    CONSTRAINT unq_funcionario_email
        UNIQUE (email),
    CONSTRAINT unq_funcionario_telefone
        UNIQUE (telefone)
)ENGINE=INNODB;