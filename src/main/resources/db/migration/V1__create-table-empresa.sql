CREATE TABLE empresa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    razao_social VARCHAR(100) NOT NULL,
    nome_fantasia VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(100) NULL,
    ativo TINYINT(1) NOT NULL,
    CONSTRAINT pk_empresa_id
        PRIMARY KEY (id),
    CONSTRAINT unq_empresa_razao_social
        UNIQUE(razao_social),
    CONSTRAINT unq_empresa_nome_fantasia
        UNIQUE(nome_fantasia),
    CONSTRAINT unq_empresa_cnpj
        UNIQUE(cnpj)
)ENGINE=INNODB;