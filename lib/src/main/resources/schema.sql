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

insert into employeetypes (position) values ('manager');
insert into employees (firstname, lastname, username, pass, employeetype) values ('Drake', 'Taylor', 'drake.taylor', 'drake', 1);