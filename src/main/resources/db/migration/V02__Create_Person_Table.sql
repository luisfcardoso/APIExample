CREATE TABLE person (
	id BIGSERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	address TEXT,
	number TEXT,
	complement TEXT,
	neighborhood TEXT,
	zip TEXT,
	city TEXT,
	state TEXT,
	active BOOLEAN NOT NULL
);

INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('João Carlos', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Maria Rita dos Santos', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Pedro Cardoso', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Flávio Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Marcos Vinícius Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Ana Barbosa', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Jéssica Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Verônica Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Cátia Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO person (name, address, number, complement, neighborhood, zip, city, state, active) values ('Ísis Montes', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);