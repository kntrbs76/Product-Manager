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

<<<<<<< HEAD
--Populate DB
INSERT INTO goods (name, description, place_storage, create_date, price)
VALUES ('Name1','Description1','1','2010-11-13', 3);
INSERT INTO goods (name, description, place_storage,create_date , price)
VALUES ('Name2','Description2','2','2014-09-23', 10);
=======
>>>>>>> dev
