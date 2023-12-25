CREATE TABLE IF NOT EXISTS public.files
(
    id serial primary key,
    path varchar(2056),
    name varchar(1024)
);

ALTER TABLE public.authors
    ADD COLUMN file_id int REFERENCES files(id);

ALTER TABLE public.books
    ADD COLUMN file_id int REFERENCES files(id);