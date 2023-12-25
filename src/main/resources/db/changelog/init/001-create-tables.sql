-- Table: public.role

create table if not exists role(
    id serial primary key,
    name varchar(255) UNIQUE
    );


insert into role(name) values('ROLE_ADMIN') ON CONFLICT DO NOTHING;
insert into role(name) values('ROLE_USER') ON CONFLICT DO NOTHING;

-- Table: public.users

create table if not exists users(
    id serial primary key,
    username varchar(255) UNIQUE,
    password varchar(255),
    registration_date timestamp without time zone
    );

-- Table: public.user_role

create table if not exists user_role(
    id serial primary key,
    user_id int references users(id),
    role_id int references role(id)
    );


-- Table: public.authors

CREATE TABLE IF NOT EXISTS public.authors
(
    id serial primary key,
    birth_date timestamp without time zone,
    first_name varchar(256),
    last_name varchar(256),
    biography varchar(32192)
    );

-- Table: public.genres

CREATE TABLE IF NOT EXISTS public.genres
(
    id serial primary key,
    name varchar(256)
    );

-- Table: public.books

CREATE TABLE IF NOT EXISTS public.books
(
    id serial primary key,
    title varchar(256),
    author int references authors(id),
    genre int references genres(id)
    );

-- Table: public.reviews

CREATE TABLE IF NOT EXISTS public.reviews
(
    id serial primary key,
    publication_time timestamp without time zone,
    book int references books(id),
    title varchar(256),
    text varchar(32192),
    mark int
    );

-- Table: public.comments

CREATE TABLE IF NOT EXISTS public.comments
(
    id serial primary key,
    publication_time timestamp without time zone,
    text varchar(1024),
    author int references users(id),
    review int references reviews(id)
    );

