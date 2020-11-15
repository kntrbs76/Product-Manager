--Create DB
CREATE DATABASE product;
--Init DB
CREATE TABLE IF NOT EXISTS goods (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(512) NOT NULL,
    description VARCHAR(1024) NOT NULL,
    place_storage BIGINT NOT NULL,
    create_date date NOT NULL,
    price BIGINT NOT NULL
);
