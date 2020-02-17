package sql2o;

import dao.RangerDao;
import models.Ranger;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oRanger implements RangerDao {
    private final Sql2o sql2o;

    public Sql2oRanger(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add( int ranger_id, String ranger_name) {
        String sql = "INSERT INTO rangers (ranger_id, ranger_name) VALUES (:ranger_id, :ranger_name)";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("ranger_id", ranger_id)
                    .addParameter("ranger__name", ranger_name)
                    .executeUpdate();

        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

@Override
    public List<Ranger> getAll(){
        String sql = "SELECT * FROM rangers";
        try(Connection connection = sql2o.open()) {
            return connection.createQuery(sql).executeAndFetch(Ranger.class);
        }
    }

    @Override
    public Ranger find(int ranger_id){
        try(Connection connection = sql2o.open()) {
            String sql = "SELECT * FROM rangers where ranger_id=:ranger_id";
            Ranger ranger = connection.createQuery(sql)
                    .addParameter("ranger_id", ranger_id)
                    .executeAndFetchFirst(Ranger.class);
            return ranger;
        }
    }


}
