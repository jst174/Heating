DROP TABLE IF EXISTS rooms CASCADE;
CREATE TABLE rooms
(
    id          SERIAL PRIMARY KEY NOT NULL,
    name        VARCHAR(50)        NOT NULL,
    number      VARCHAR(10)        NOT NULL,
    temperature INTEGER            NOT NULL

);