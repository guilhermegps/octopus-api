--liquibase formatted sql
--changeset guilherme.gps:APP_CREATE_EVENTS_TABLES

CREATE TABLE APP.event_type (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	description varchar(60) NOT NULL,
	CONSTRAINT pk_event_type PRIMARY KEY (id)
);

CREATE TABLE APP.event (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	dt_event timestamp DEFAULT now() NOT NULL,
	user_id UUID NOT NULL,
	event_type_id UUID NOT NULL,
	description varchar(255) NULL,
	user_ip varchar(40) NULL,
	CONSTRAINT pk_event PRIMARY KEY (id),
	CONSTRAINT fk_event_event_type FOREIGN KEY (event_type_id) REFERENCES APP.event_type(id),
	CONSTRAINT fk_event_user FOREIGN KEY (user_id) REFERENCES AUTH.user_app(id)
);