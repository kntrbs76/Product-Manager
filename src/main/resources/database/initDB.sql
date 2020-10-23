CREATE TABLE IF NOT EXISTS goods (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(512) NOT NULL,
    description VARCHAR(1024) NOT NULL,
    create_date DATE NOT NULL,
    place_storage BIGINT NOT NULL,
    reserved BOOLEAN
);