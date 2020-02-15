
import models.Animal;
import models.Ranger;
import models.Sighting;

import org.junit.Rule;
import org.junit.Test;

import java.util.Date;
import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingTest {
    Sighting testSighting = new Sighting(1, "Longeliani", 1, 1);
    Sighting anotherSighting = new Sighting(1, "Longeliani", 1, 1);
    Sighting firstSighting = new Sighting(1, "Longeliani", 1, 1);
    Ranger testRanger = new Ranger(1, "OleNkulal" );
    Sighting secondSighting = new Sighting(2, "Longido", 3, 2);
    Animal testAnimal = new Animal(1, "elephant", "healthy", 17, true);


    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true(){
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void Sighting_instantiatesWithLocation_String() {
        assertEquals("Longeliani", testSighting.getLocation());
    }

    @Test
    public void Sighting_instantiatesWithRangerid_int() {
        assertEquals(1, testSighting.getRanger_id());
    }

    @Test
    public void Sighting_instantiatesWithAnimalId_int() {
        assertEquals(1, testSighting.getAnimal_id());
    }

    @Test
    public void equals_returnsTrueIfLocationAndAnimalIdAreSame_true(){
        assertTrue(testSighting.equals(anotherSighting));
    }

//    @Test
//    public void save_returnsTrueIfDescriptionsAretheSame() {
//        testSighting.save();
//        assertTrue(Sighting.all().get(0).equals(testSighting));
//    }
//
//    @Test
//    public void save_assignsIdToSighting(){
//        testSighting.save();
//        Sighting savedSighting = new Sighting(1, "Masai spring", 1, 1);
//        assertEquals(savedSighting.getSighting_id(), testSighting.getSighting_id());
//    }

//    @Test
//    public void all_returnsAllInstancesOfSighting_true(){
//        firstSighting.save();
//        secondSighting.save();
//        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
//        assertEquals(true, Sighting.all().get(0).equals(secondSighting));
//    }
//    @Test
//    public void find_returnsSightingWithSameId_secondSighting(){
//        firstSighting.save();
//        secondSighting.save();
//        assertEquals(Sighting.find(secondSighting.getSighting_id()), secondSighting);
//    }

//    @Test
//    public void save_savesAnimalIdintoDB_true(){
//      testRanger.add();
//      testSighting.save();
//      Sighting savedSighting = Sighting.find(testSighting.getSighting_id());
//      assertEquals(savedSighting.getAnimal_id(), testRanger.getRanger_id());
//    }

//    @Test
//    public  void save_recordsTimeOfSightingInDatabase(){
//        testSighting.save();
//        Timestamp saveSightingDate = Sighting.find(testSighting.getSighting_id()).getLastseen();
//        Timestamp rightnow = new Timestamp(new Date().getTime());
//        assertEquals(rightnow.getDay(), saveSightingDate.getDay());
//    }

}
