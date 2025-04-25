--liquibase formatted sql
--changeset guilherme.gps:INSERT_CREDENTIAL_ADM
-- Profiles
INSERT INTO AUTH.profile (id, enabled, description) VALUES('f0c8362a-2915-48d4-8511-a1ddb909dfb1', true, 'ADM');
INSERT INTO AUTH.profile (id, enabled, description) VALUES('2b46c940-701d-486b-963e-5662bce2a4ab', true, 'USER');

-- Users
INSERT INTO AUTH.user_app (person_id, profile_id, username, password) VALUES('121634df-ce31-44a3-9370-479c6b570945', 'f0c8362a-2915-48d4-8511-a1ddb909dfb1', 'admin', '$2a$10$86t8a8327OoRTLljQ6Cqsu0PIVGyW06y8lib0sxJe0icHyQCKiXqG');