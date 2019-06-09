CREATE TABLE entry (
	id BIGSERIAL PRIMARY KEY,
	description TEXT NOT NULL,
	due_date DATE NOT NULL,
	payment_date DATE,
	amount NUMERIC(10,2) NOT NULL,
	note TEXT,
	type TEXT NOT NULL,
	category_id BIGSERIAL NOT NULL,
	person_id BIGSERIAL NOT NULL,
	FOREIGN KEY (category_id) REFERENCES category(id),
	FOREIGN KEY (person_id) REFERENCES person(id)
);

INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Monthly salary', '2017-06-10', null, 6500.00, 'Distribution of profits', 'REVENUE', 1, 1);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Trips', '2017-02-10', '2017-02-10', 100.32, null, 'EXPENSE', 2, 2);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Club', '2017-06-10', null, 120, null, 'EXPENSE', 3, 3);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Electricity Bill', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'REVENUE', 3, 4);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('DMAE', '2017-06-10', null, 200.30, null, 'EXPENSE', 3, 5);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'REVENUE', 4, 6);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Trips', '2017-06-10', null, 500, null, 'REVENUE', 1, 7);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Club', '2017-03-10', '2017-03-10', 400.32, null, 'EXPENSE', 4, 8);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Transit Department', '2017-06-10', null, 123.64, 'Ticket', 'EXPENSE', 3, 9);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Tires', '2017-04-10', '2017-04-10', 665.33, null, 'REVENUE', 5, 10);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Coffe shop', '2017-06-10', null, 8.32, null, 'EXPENSE', 1, 5);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Electronics', '2017-04-10', '2017-04-10', 2100.32, null, 'EXPENSE', 5, 4);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Instruments', '2017-06-10', null, 1040.32, null, 'EXPENSE', 4, 3);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Coffe shop', '2017-04-10', '2017-04-10', 4.32, null, 'EXPENSE', 4, 2);
INSERT INTO entry (description, due_date, payment_date, amount, note, type, category_id, person_id) values ('Snack', '2017-06-10', null, 10.20, null, 'EXPENSE', 4, 1);