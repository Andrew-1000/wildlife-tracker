import models.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Sql2o;
import sql2o.Sql2oAnimal;


import static org.junit.Assert.*;


public class AnimalTest {
    private Sql2o sql2o;
    Animal testAnimal = new Animal(1, "elephant", "healthy", 17, true);
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

//    @Test
//    public void save_insertObjectsIntoDatabase_Animal() {
//        sql2oAnimal.add(1, "elephant", "healthy", "young", "young");
//        assertTrue(getAll().get(0).equals(sql2oAnimal));
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfAnimals_true() {
//        Animal firstAnimal = new Animal(1, "elephant", "healthy", 17, true);
//        firstAnimal.add();
//        Animal secondAnimal = new Animal(2, "lion", "ill", 4, false);
//        secondAnimal.add();
//        Animal thirdAnimal = new Animal(3, "girraffe", "healthy", 6, true);
//        thirdAnimal.add();
//        assertEquals(true, Animal.getAll().get(0).equals(firstAnimal));
//        assertEquals(true, Animal.getAll().get(1).equals(secondAnimal));
//        assertEquals(true, Animal.getAll().get(2).equals(thirdAnimal));
//    }
//
//    @Test
//    public void save_assignsIdToObject() {
//        testAnimal.add();
//        Animal savedAnimal = getAll().get(0);
//        assertEquals(testAnimal.getAnimal_id(), savedAnimal.getAnimal_id());
//    }
//
//    @Test
//    public void find_returnsAnimalWithSameId_secondAnimal(){
//        Animal firstAnimal = new Animal(1, "elephant", "healthy", 17, true);
//        firstAnimal.add();
//        Animal secondAnimal = new Animal(2, "elephant", "healthy", 17, true);
//        secondAnimal.add();
//        assertEquals(Animal.findById(secondAnimal.getAnimal_id()), secondAnimal);
//    }
}
