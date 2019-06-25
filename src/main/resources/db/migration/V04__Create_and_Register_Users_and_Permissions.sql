CREATE TABLE users (
	id BIGSERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	email TEXT NOT NULL,
	password TEXT NOT NULL
);

CREATE TABLE permission (
	id BIGSERIAL PRIMARY KEY,
	description TEXT NOT NULL
);

CREATE TABLE users_permission (
	id_users BIGSERIAL NOT NULL,
	id_permission BIGSERIAL NOT NULL,
	PRIMARY KEY (id_users, id_permission),
	FOREIGN KEY (id_users) REFERENCES users(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
);

INSERT INTO users (id, name, email, password) values (1, 'Administrator', 'admin@email.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO users (id, name, email, password) values (2, 'Luis', 'luis@email.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_CATEGORY');
INSERT INTO permission (id, description) values (2, 'ROLE_SEARCH_CATEGORY');

INSERT INTO permission (id, description) values (3, 'ROLE_REGISTER_PERSON');
INSERT INTO permission (id, description) values (4, 'ROLE_REMOVER_PERSON');
INSERT INTO permission (id, description) values (5, 'ROLE_SEARCH_PERSON');

INSERT INTO permission (id, description) values (6, 'ROLE_REGISTER_ENTRY');
INSERT INTO permission (id, description) values (7, 'ROLE_REMOVER_ENTRY');
INSERT INTO permission (id, description) values (8, 'ROLE_SEARCH_ENTRY');

-- Admin
INSERT INTO users_permission (id_users, id_permission) values (1, 1);
INSERT INTO users_permission (id_users, id_permission) values (1, 2);
INSERT INTO users_permission (id_users, id_permission) values (1, 3);
INSERT INTO users_permission (id_users, id_permission) values (1, 4);
INSERT INTO users_permission (id_users, id_permission) values (1, 5);
INSERT INTO users_permission (id_users, id_permission) values (1, 6);
INSERT INTO users_permission (id_users, id_permission) values (1, 7);
INSERT INTO users_permission (id_users, id_permission) values (1, 8);

-- Luis
INSERT INTO users_permission (id_users, id_permission) values (2, 2);
INSERT INTO users_permission (id_users, id_permission) values (2, 5);
INSERT INTO users_permission (id_users, id_permission) values (2, 8);