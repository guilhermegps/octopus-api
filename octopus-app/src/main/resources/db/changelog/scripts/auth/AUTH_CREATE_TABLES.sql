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
	id_profile UUID NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	name varchar(100) NOT NULL,
	cpf varchar(11) NOT NULL UNIQUE,
	password varchar(255) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
	CONSTRAINT pk_user PRIMARY KEY (id),
	CONSTRAINT fk_user_profile FOREIGN KEY (id_profile) REFERENCES AUTH.profile(id)
);