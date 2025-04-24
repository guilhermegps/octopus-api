--liquibase formatted sql
--changeset guilherme.gps:INSERT_PERSONAL_ADM

-- People
INSERT INTO PERSONAL.person (id, name, cpf, dt_birth, email) 
		VALUES('121634df-ce31-44a3-9370-479c6b570945', 'System Administrator', '12345678909', current_date, 'admin@system.com');
		
-- phones
INSERT INTO PERSONAL.phone (id, id_person, number) VALUES('2c370655-cf30-45e6-9e87-b1f25652ac42', '121634df-ce31-44a3-9370-479c6b570945', '(610) 837-2954 x9476');
INSERT INTO PERSONAL.phone (id, id_person, number) VALUES('47a9ebfb-0a77-42a4-a25f-7a96d140ee3f', '121634df-ce31-44a3-9370-479c6b570945', '1-955-642-1190 x783');