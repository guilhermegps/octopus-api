--liquibase formatted sql
--changeset guilherme.gps:INSERT_EVENTS_TYPES

-- Evento
INSERT INTO APP.event_type (id, enabled, description) VALUES('359478a8-f1f6-486e-bdc2-504bbead5fbc', true, 'INCLUSION');
INSERT INTO APP.event_type (id, enabled, description) VALUES('e2f4f40c-0340-4404-ad32-1a14692de709', true, 'UPDATE');
INSERT INTO APP.event_type (id, enabled, description) VALUES('d3320a32-b803-40f9-ab35-13c29833f214', true, 'DISABLING');
INSERT INTO APP.event_type (id, enabled, description) VALUES('a6c4efd6-0407-4bfb-9400-dd6618b0b069', true, 'REMOVAL');
INSERT INTO APP.event_type (id, enabled, description) VALUES('ca359094-7080-4d4e-b3b6-fd64f5ca7a71', true, 'VIEW');

INSERT INTO APP.event_type (id, enabled, description) VALUES('7fc34510-0501-4768-beca-bd9345683a93', true, 'AUTHENTICATION');
INSERT INTO APP.event_type (id, enabled, description) VALUES('3e2f3d03-42c5-4ae2-a240-114d5b332b4c', true, 'AUTHENTICATION_FAIL');
INSERT INTO APP.event_type (id, enabled, description) VALUES('eb37a61c-ce15-4b88-87f0-68b75911239f', true, 'ACCESS_DENIED');

INSERT INTO APP.event_type (id, enabled, description) VALUES('8d8d76b8-b78b-407b-92c9-d5c452713c65', true, 'FILE_GENERATED');