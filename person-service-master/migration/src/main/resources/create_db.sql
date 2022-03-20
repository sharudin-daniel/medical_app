CREATE TABLE IF NOT EXISTS medical_schema.address
(
    id bigint NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    contact_id bigint NOT NULL,
    country_id bigint NOT NULL,
    index integer,
    city VARCHAR(255)  NOT NULL,
    street VARCHAR(255)  NOT NULL,
    building VARCHAR(32)  NOT NULL,
    flat VARCHAR(32),
    CONSTRAINT "address.id" PRIMARY KEY (id),
    CONSTRAINT "address.contact_id" FOREIGN KEY (contact_id)
    REFERENCES medical_schema.contact (id)
    )


CREATE TABLE IF NOT EXISTS medical_schema.contact
(
    id bigint NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    profile_link text ,
    phone_number VARCHAR(32) NOT NULL,
    email VARCHAR(128),
    )


CREATE TABLE IF NOT EXISTS medical_schema.illness
(
    id bigint NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    medical_card_id bigint NOT NULL,
    type_id bigint,
    hearviness CHAR,
    appearance_dttm TIMESTAMP with time zone NOT NULL,
    recovery_dt DATE,
    CONSTRAINT "illness.medical_card_id" FOREIGN KEY (medical_card_id)
    REFERENCES medical_schema.medical_card (id) MATCH SIMPLE
    )


CREATE TABLE IF NOT EXISTS medical_schema.medical_card
(
    id bigint NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    client_status CHAR ,
    med_status CHAR,
    registry_dt DATE NOT NULL,
    comment text ,
    CONSTRAINT "medical_card.id" PRIMARY KEY (id)
    )


CREATE TABLE IF NOT EXISTS medical_schema.person_data
(
    id bigint NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    last_name VARCHAR(255)  NOT NULL,
    first_name VARCHAR(255)  NOT NULL,
    birth_dt DATE NOT NULL,
    age SMALLINT ,
    sex CHAR NOT NULL,
    contact_id bigint NOT NULL,
    medical_card_id bigint NOT NULL,
    parent_id bigint,
    CONSTRAINT "person.contact_id" FOREIGN KEY (contact_id)
    REFERENCES medical_schema.contact (id)

    CONSTRAINT "person.medical_caard_id" FOREIGN KEY (medical_card_id)
    REFERENCES medical_schema.medical_card (id)

    CONSTRAINT "person.parent_id" FOREIGN KEY (parent_id)
    REFERENCES medical_schema.person_data (id)

    )
