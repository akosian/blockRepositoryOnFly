CREATE TABLE IF NOT EXISTS IMPORTS (
    id INT PRIMARY KEY UNIQUE,
    "name" VARCHAR(16),
    status VARCHAR(16)
);

CREATE SEQUENCE IF NOT EXISTS seq_imports
    START 30 OWNED BY IMPORTS.id;