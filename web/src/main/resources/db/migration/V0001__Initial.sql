CREATE TABLE "user" (
  id            SERIAL PRIMARY KEY NOT NULL,
  email         TEXT               NOT NULL,
  password_hash TEXT               NOT NULL
);

CREATE TABLE "data_source" (
  id   SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR
);

CREATE TABLE "schema" (
  id             SERIAL PRIMARY KEY NOT NULL,
  data_source_id INT REFERENCES data_source (id),
  name           VARCHAR
);

CREATE TABLE "table" (
  id        SERIAL PRIMARY KEY NOT NULL,
  schema_id INT REFERENCES "schema"(id),
  name      VARCHAR
);

CREATE TABLE "field" (
  id        SERIAL PRIMARY KEY NOT NULL,
  table_id  INT REFERENCES "table"(id),
  name      VARCHAR
);
