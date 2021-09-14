CREATE TABLE IF NOT EXISTS USERS (
    id INT PRIMARY KEY UNIQUE,
    username VARCHAR(16),
    email VARCHAR(16),
    password VARCHAR(16)
);

CREATE SEQUENCE IF NOT EXISTS seq_user
    START 30 OWNED BY USERS.id;
--
-- INSERT INTO USERS(username, email, password)
-- VALUES ('admin', 'admin@gmail.com', 'admin');