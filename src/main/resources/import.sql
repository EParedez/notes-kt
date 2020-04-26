CREATE TABLE keyspacenotes.notes (
    id int primary key,
    name text,
    description text,
    plain text,
    html text
);


INSERT INTO notes (id, description, html, name, plain) VALUES (uuid(), 'd1', '<p>hola mundo</p>', 'name1', 'hola mundo');