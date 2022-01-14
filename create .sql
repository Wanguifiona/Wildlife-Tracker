

CREATE DATABASE wildlife_tracker;

\c wildlife_tracker;

CREATE TABLE animals (
   id serial PRIMARY KEY,
   name varchar,
   health varchar,
   age varchar,
   type varchar
);

CREATE TABLE sightings (
   id serial PRIMARY KEY,
   animalid int,
   location varchar,
   rangername varchar,
   lastseen timestamp
   );

CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;


--heroku pg:psql --app wildlifetracker1
--\c database no
--\dt
--CREATE TABLE animals(------)
--CREATE TABLE sightings(-----)