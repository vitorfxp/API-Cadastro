CREATE TABLE tb_missoes
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(255),
    descricao VARCHAR(255),
    rank      VARCHAR(50)
);

CREATE TABLE tb_cadastro
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome       VARCHAR(255),
    email      VARCHAR(255) UNIQUE,
    nivel      VARCHAR(50),
    aldeia     VARCHAR(255),
    idade      INT NOT NULL,
    missoes_id BIGINT,
    CONSTRAINT fk_missoes FOREIGN KEY (missoes_id) REFERENCES tb_missoes (id)
);