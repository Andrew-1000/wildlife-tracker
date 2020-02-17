SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS rangers (ranger_id int PRIMARY KEY, ranger_name varchar);
CREATE TABLE IF NOT EXISTS animals (animal_id int PRIMARY KEY, animal_name varchar, health varchar, age varchar, endangered varchar);
CREATE TABLE IF NOT EXISTS sightings (sighting_id int PRIMARY KEY, location varchar animal_id INTEGER,ranger_id INTEGER);

