package models;

import database.Database;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sighting {
    private int sighting_id;
    private String location;
    private int ranger_id;
    private int animal_id;
    private Timestamp lastseen;

    public Sighting(int sighting_id, String location, int ranger_id, int animal_id) {
        this.sighting_id = sighting_id;
        this.location = location;
        this.ranger_id = ranger_id;
        this.animal_id = animal_id;
    }


    public int getSighting_id() {
        return sighting_id;
    }

    public String getLocation() {
        return location;
    }

    public int getRanger_id() {
        return ranger_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public Timestamp getLastseen() {
        return lastseen;
    }

    @Override

    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        }else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getLocation().equals(newSighting.getLocation()) &&
                    this.getAnimal_id() == newSighting.getAnimal_id();
        }
    }

    public void save(){
        try (Connection connection = Database.sql2o.open()) {
            String sql = "INSERT INTO sightings (sighting_id, location, ranger_id, animal_id, lastseen) VALUES(:sighting_id, :location, :ranger_id, :animal_id, now())";
            this.sighting_id = (int) connection.createQuery(sql, true)
                    .addParameter("sighting_id", this.sighting_id)
                    .addParameter("location", this.location)
                    .addParameter("ranger_id", this.ranger_id)
                    .addParameter("animal_id", this.animal_id)
                    .executeUpdate()
                    .getKey();

        }
    }
    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection connection = Database.sql2o.open()){
            return connection.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }

    public static Sighting find(int sighting_id) {
        try(Connection connection = Database.sql2o.open()){
            String sql = "SELECT * FROM sightings WHERE sighting_id = :sighting_id";
            Sighting sighting = connection.createQuery(sql)
                    .addParameter("sighting_id", sighting_id)
                    .executeAndFetchFirst(Sighting.class);

            return sighting;
        }
    }

}
