-- CREATE DATABASE users;
CREATE SCHEMA IF NOT EXISTS users_scheme;

CREATE TABLE users_scheme.user
(
    "id"          serial unique,
    "email"       varchar(255),
    "first_name"  varchar(255),
    "last_name"   varchar(255),
    "father_name" varchar(255),
    gender varchar(255) NOT NULL DEFAULT 'FEMALE',
    avatar_url varchar(255),
    about text,
    hard_skills text,
    nikname varchar(255),
    phone varchar(255),
    deleted bool NOT NULL DEFAULT false,
    "birthday"    timestamp,
    "created_at"  timestamp DEFAULT now()
);

CREATE TABLE users_scheme.subscription
(
    "id"            integer PRIMARY KEY,
    "subscriber_id" integer,
    "user_id"       integer
);

ALTER TABLE users_scheme.subscription
    ADD FOREIGN KEY ("subscriber_id") REFERENCES users_scheme.user (id);

ALTER TABLE users_scheme.subscription
    ADD FOREIGN KEY ("user_id") REFERENCES users_scheme.user (id);

ALTER TABLE users_scheme.subscription ALTER COLUMN  subscriber_id SET NOT NULL;
ALTER TABLE users_scheme.subscription ALTER COLUMN  user_id SET NOT NULL;
ALTER TABLE users_scheme.user ALTER COLUMN email SET NOT NULL;

-- Авторизация как правило происходит по почте и паролю.
CREATE UNIQUE INDEX IDX_user_email ON users_scheme.user (email);
CREATE UNIQUE INDEX IDX_user_gender ON users_scheme.user (gender);
-- Ускоряет выборку по связанным моделям
CREATE INDEX IDX_subscribers ON users_scheme.subscription (user_id, subscriber_id);