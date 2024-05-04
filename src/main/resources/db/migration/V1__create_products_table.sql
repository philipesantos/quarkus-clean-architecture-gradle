CREATE TABLE products(
    id bigserial PRIMARY KEY,
    serial character varying NOT NULL,
    name character varying NOT NULL
);
CREATE UNIQUE INDEX ON products (serial);