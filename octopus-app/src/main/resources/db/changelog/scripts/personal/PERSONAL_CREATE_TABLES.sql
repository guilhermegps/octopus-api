--liquibase formatted sql
--changeset guilherme.gps:PERSONAL_CREATE_TABLES
CREATE SCHEMA IF NOT EXISTS PERSONAL;

CREATE TABLE PERSONAL.state (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	name varchar(100) NOT NULL,
	abbreviation varchar(2) NOT NULL,
	CONSTRAINT pk_state PRIMARY KEY (id)
);

CREATE TABLE PERSONAL.address (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	state_id UUID NOT NULL,
	street varchar(100) NOT NULL,
	complement varchar(200) NULL,
	zip_code varchar(10) NOT NULL,
	CONSTRAINT pk_address PRIMARY KEY (id),
	CONSTRAINT fk_address_state FOREIGN KEY (state_id) REFERENCES PERSONAL.state(id)
);

CREATE TABLE PERSONAL.person (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	address_id UUID NULL,
	name varchar(100) NOT NULL,
	cpf varchar(11) NOT NULL UNIQUE, -- brazilian personal identification
	dt_birth date NOT NULL,
	sex varchar(1) NULL,
	email varchar(50) NOT NULL,
	CONSTRAINT pk_person PRIMARY KEY (id),
	CONSTRAINT fk_person_address FOREIGN KEY (address_id) REFERENCES PERSONAL.address(id)
);

CREATE TABLE PERSONAL.phone (
	id UUID DEFAULT RANDOM_UUID() NOT NULL,
	code INT auto_increment NOT NULL UNIQUE,
	enabled bool DEFAULT true NOT NULL,
	person_id UUID NOT NULL,
	number varchar(30) NOT NULL,
	CONSTRAINT pk_phone PRIMARY KEY (id),
	CONSTRAINT fk_phone_person FOREIGN KEY (person_id) REFERENCES PERSONAL.person(id)
);

