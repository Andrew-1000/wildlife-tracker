package sql2o;

import dao.AnimalDao;
import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAnimal implements AnimalDao {
   private final Sql2o sql2o;
    public Sql2oAnimal(Sql2o sql2o){
       this.sql2o=sql2o;
    }


    @Override
    public void add(int animal_id, String animal_name, String health, String age, String endangered) {
        String sql = "INSERT INTO animals (animal_id, animal_name, health, age, endangered) VALUES (:animal_id, :animal_name, :health, :age, :endangered)";
        try(Connection conn = sql2o.open()) {
            conn.createQuery(sql )
                    .addParameter("animal_id", animal_id)
                    .addParameter("animal_name", animal_name)
                    .addParameter("health", health)
                    .addParameter("age", age)
                    .addParameter("endangered", endangered)
                    .executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }


    @Override
    public  List<Animal> getAll() {
        String sql = "SELECT * FROM animals";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }

    }
    @Override
    public  Animal findById(int animal_id) {
        try(Connection connection = sql2o.open()){
            String sql = "SELECT * FROM animals WHERE animal_id= :animal_id";
            Animal animal = connection.createQuery(sql)
                    .addParameter("animal_id", animal_id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }



}
