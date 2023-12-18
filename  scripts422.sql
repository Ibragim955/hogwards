create table people(
    people_id serial primary key not null,
    name     text,
    age      int,
    license  boolean,

);

create table car(
    car_id  serial primary key not null,
    brand   text,
    model   text,
    price   int,
);

create table carPeople (
    people_id int references people(people_id),
    car_id    int references car(car_id),
    primary key (people_id, car_id)
);