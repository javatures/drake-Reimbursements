create table employeetypes (
    id serial primary key,
    position text unique
);

create table employees (
    id serial primary key,
    firstname text,
    lastname text,
    username text,
    pass text,
    employeetype int references employeetypes(id)
);

