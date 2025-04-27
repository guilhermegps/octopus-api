--liquibase formatted sql
--changeset guilherme.gps:AUTH_CREATE_TABLES
CREATE SCHEMA IF NOT EXISTS AUTH;

CREATE TABLE AUTH.profile (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	description varchar(50) NOT NULL,
	CONSTRAINT pk_profile PRIMARY KEY (id)
);

CREATE TABLE AUTH.user_app (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	person_id UUID NOT NULL,
	profile_id UUID NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password varchar(255) NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY (id),
	CONSTRAINT fk_user_person FOREIGN KEY (person_id) REFERENCES PERSONAL.person(id),
	CONSTRAINT fk_user_profile FOREIGN KEY (profile_id) REFERENCES AUTH.profile(id)
);