
import models.Animal;
import models.Ranger;
import models.Sighting;

import org.junit.Rule;
import org.junit.Test;

import java.util.Date;
import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
public class SightingTest {
    Sighting testSighting = new Sighting(1, "Longeliani", 1, 1);
    Sighting anotherSighting = new Sighting(1, "Longeliani", 1, 1);
    Sighting firstSighting = new Sighting(1, "Longeliani", 1, 1);
    Ranger testRanger = new Ranger(1, "OleNkulal" );
    Sighting secondSighting = new Sighting(2, "Longido", 3, 2);
    Animal testAnimal = new Animal(1, "elephant", "healthy", "17", "true");


    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void Sighting_instantiatesWithSightingId_true(){
        assertEquals(1, testSighting.getSighting_id());
    }
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





}
