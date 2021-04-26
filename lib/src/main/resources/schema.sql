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

create table requests (
    id serial primary key,
    reason text,
    picture text,
    approved boolean,
    employee int references employees(id),
    manager int references employees(id)
);

insert into employeetypes (position) values ('manager');
insert into employeetypes (position) values ('employee');
insert into employees (firstname, lastname, username, pass, employeetype) values ('Drake', 'Taylor', 'drake.taylor', 'drake', 2);
insert into employees (firstname, lastname, username, pass, employeetype) values ('Mehrab', 'Rahman', 'mehrab.rahman', 'mehrab', 1);