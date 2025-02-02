CREATE TABLE IF NOT EXISTS user_app
(
    id         SERIAL NOT NULL,
    username   VARCHAR(255),
    password   VARCHAR(255),
    dni        VARCHAR(100) UNIQUE,
    created_at TIMESTAMP DEFAULT now(),
    CONSTRAINT pk_customer_id PRIMARY KEY (id)
);
