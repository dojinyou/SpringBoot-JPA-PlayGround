-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE category (
    id          bigserial                   NOT NULL,
    name        varchar(31)                 NOT NULL,
    created_at  timestamp   NOT NULL,
    updated_at  timestamp   NOT NULL
);

ALTER TABLE category ADD CONSTRAINT PK_CATEGORY PRIMARY KEY (id);
CREATE UNIQUE INDEX idx_category_name ON category(name);

CREATE TABLE store (
    id          bigserial                   NOT NULL,
    name        varchar(31)                 NOT NULL,
    created_at  timestamp   NOT NULL,
    updated_at  timestamp   NOT NULL
);

ALTER TABLE store ADD CONSTRAINT PK_STORE PRIMARY KEY (id);
CREATE UNIQUE INDEX idx_store_name ON store(name);

CREATE TABLE store_category (
    id          bigserial                   NOT NULL,
    store_id    bigint                      NOT NULL,
    category_id bigint                      NOT NULL,
    created_at  timestamp   NOT NULL DEFAULT NOW()
);

ALTER TABLE store_category ADD CONSTRAINT PK_STORE_CATEGORY PRIMARY KEY (id);
CREATE INDEX idx_store_category_store_id_category_id ON store_category(store_id, category_id);
