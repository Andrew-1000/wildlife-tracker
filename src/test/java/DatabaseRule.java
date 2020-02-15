import database.Database;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class DatabaseRule extends ExternalResource {



    @Override
    protected void before() {
        Database.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "admin");    }

    @Override
    protected void after() {
        try (Connection connection = Database.sql2o.open()) {
            String deleteRangerQuery = "DELETE FROM rangers *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            connection.createQuery(deleteSightingsQuery).executeUpdate();
            connection.createQuery(deleteRangerQuery).executeUpdate();
        }
    }
}
