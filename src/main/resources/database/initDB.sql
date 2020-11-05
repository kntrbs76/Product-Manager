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

--Populate DB
INSERT INTO goods (name, description, place_storage, create_date, price)
VALUES ('Name1','Description1','1','2010-11-13', 3);
INSERT INTO goods (name, description, create_date, place_storage, price)
VALUES ('Name2','Description2','2015-10-27','2', 10);