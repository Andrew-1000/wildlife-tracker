package sql2o;

import dao.SightingDao;
import database.Database;
import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSighting implements SightingDao {
    private final Sql2o sql2o;
    public Sql2oSighting(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public List<Sighting> getAll() {
        String sql = "SELECT * FROM sightings";
        try(Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }

    @Override
    public Sighting find(int sighting_id) {
        try(Connection connection = sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE sighting_id = :sighting_id";
            Sighting sighting = connection.createQuery(sql)
                    .addParameter("sighting_id", sighting_id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }

    }


    @Override
    public void add(int sighting_id, String location, int animal_id, int ranger_id) {
        String sql = "INSERT INTO sightings (sighting_id,location, ranger_id, animal_id) VALUES (:sighting_id,:location, :ranger_id, :animal_id)";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("sighting_id", sighting_id)
                    .addParameter("location", location)
                    .addParameter("ranger_id", ranger_id)
                    .addParameter("animal_id", animal_id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
