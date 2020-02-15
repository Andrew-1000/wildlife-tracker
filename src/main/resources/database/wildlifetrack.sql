SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS ranger (ranger_id serial PRIMARY KEY, ranger_name varchar);
CREATE TABLE IF NOT EXISTS animal (animal_id serial PRIMARY KEY, animal_name varchar, age varchar, endangered BOOLEAN);
CREATE TABLE IF NOT EXISTS sightings (sighting_id int PRIMARY KEY, location varchar animal_id INTEGER,ranger_id INTEGER);

