import models.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Sql2o;
import sql2o.Sql2oAnimal;


import static org.junit.Assert.*;


public class AnimalTest {
    private Sql2o sql2o;
    Animal testAnimal = new Animal(1, "elephant", "healthy", "17", "true");
    Sql2oAnimal sql2oAnimal = new Sql2oAnimal(sql2o);

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true(){
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getAnimal_name_animalInstantiatesWithName_elephant(){
        assertEquals("elephant", testAnimal.getAnimal_name());
    }


}
