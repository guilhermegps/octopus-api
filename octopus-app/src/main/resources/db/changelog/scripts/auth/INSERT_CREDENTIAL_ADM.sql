--liquibase formatted sql
--changeset guilherme.gps:INSERT_CREDENTIAL_ADM
-- Perfis
INSERT INTO AUTH.profile (id, enabled, description) VALUES('f0c8362a-2915-48d4-8511-a1ddb909dfb1', true, 'ADM');
INSERT INTO AUTH.profile (id, enabled, description) VALUES('2b46c940-701d-486b-963e-5662bce2a4ab', true, 'USER');

-- Usuarios
INSERT INTO AUTH.user_app (id_profile, username, name, cpf, password, email) VALUES('f0c8362a-2915-48d4-8511-a1ddb909dfb1', 'admin', 'System Administrator', '12345678909', '$2a$10$86t8a8327OoRTLljQ6Cqsu0PIVGyW06y8lib0sxJe0icHyQCKiXqG', 'admin@system.com');