CREATE TABLE IF NOT EXISTS tasks
(
    id        SERIAL PRIMARY KEY,
    title     VARCHAR(255) NOT NULL,
    completed BOOLEAN      NOT NULL
);