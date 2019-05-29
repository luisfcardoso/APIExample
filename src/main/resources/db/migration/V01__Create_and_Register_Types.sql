CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    NAME TEXT NOT NULL
);

INSERT INTO category (NAME) values ('Lazer');
INSERT INTO category (NAME) values ('Alimentação');
INSERT INTO category (NAME) values ('Supermercado');
INSERT INTO category (NAME) values ('Farmácia');
INSERT INTO category (NAME) values ('Outros');