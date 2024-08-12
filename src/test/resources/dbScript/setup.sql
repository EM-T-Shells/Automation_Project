PRAGMA foreign_keys = ON;

drop table if exists moons;

drop table if exists planets;

drop table if exists users;

create table users(id integer primary key, username text unique not null check (length(username) <= 30), password text not null check (length(password) <= 30));

insert into users (username, password) values ('Batman', 'I am the night');

create table planets(id integer primary key, name text not null check (length(name) <= 30), ownerId integer not null, image blob, foreign key(ownerId) references users(id) on delete cascade);

insert into planets (name, ownerId, image) values ('Earth', 1, ?);

insert into planets (name, ownerId, image) values ('Mars', 1, ?);

create table moons(id integer primary key, name text not null check (length(name) <= 30), myPlanetId integer not null, image blob, foreign key(myPlanetId) references planets(id) on delete cascade);

insert into moons (name, myPlanetId, image) values ('Luna', 1, ?);

insert into moons (name, myPlanetId, image) values ('Titan', 2, ?);
