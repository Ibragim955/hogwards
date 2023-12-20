-- liquibase formatted sql

-- changeset chek:1
CREATE TABLE student (
                       id SERIAL,
                       name TEXT
)
    -- changeset chek:2
ALTER TABLE student ADD age TEXT;