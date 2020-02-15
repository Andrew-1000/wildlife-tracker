import models.Ranger;
import models.Sighting;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Sql2o;
import sql2o.Sql2oAnimal;
import sql2o.Sql2oRanger;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RangerTest {
    Ranger testRanger = new Ranger(1, "OleNkulal");
    Sighting firstSighting = new Sighting(1, "Masai spring", 1, 1);
    Sighting secondSighting = new Sighting(2, "Longido", 3, 2);

    private Sql2o sql20;
    Sql2oRanger sql2oRanger = new Sql2oRanger(sql20);

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();


    @Test
    public void ranger_instantiatesCorrectly_true(){
           assertEquals(true, testRanger instanceof Ranger);
    }

    @Test

    public void getRanger_name_rangerInstantiateswithName_OleNkulal(){
          assertEquals("OleNkulal", testRanger.getRanger_name());

    }

//    @Test
//
//    public void save_insertsObjectIntoDatabase_Ranger(){
//        Ranger ranger = new Ranger(1, "OleNkulal");
//        sql2oRanger.add(1, "OleNkulal");
//        assertEquals(true, Sql2oRanger.getAll().get(0).equals(sql2oRanger));
//    }

//    @Test
//    public void all_returnsAllinstancesOfRanger_true(){
//        Ranger firstRanger = new Ranger(1, "OleNkulal");
//        firstRanger.add();
//        Ranger secondRanger = new Ranger(2, "Kimani");
//        secondRanger.add();
//        Ranger thirdRanger = new Ranger(3, "Sarankule");
//        thirdRanger.add();
//        assertEquals(true, Ranger.getAll().get(0).equals(firstRanger));
//        assertEquals(true, Ranger.getAll().get(1).equals(secondRanger));
//        assertEquals(true, Ranger.getAll().get(2).equals(thirdRanger));
//    }
//
//    @Test
//    public void save_assignsIdToObject(){
//         testRanger.add();
//        Ranger savedRanger = Ranger.getAll().get(0);
//        assertEquals(testRanger.getRanger_id(), savedRanger.getRanger_id());
//    }

//    @Test
//    public void find_returnsPersonWithSameId_thirdPerson(){
//        Ranger firstRanger = new Ranger(1, "OleNkulal");
//        firstRanger.add();
//        Ranger secondRanger = new Ranger(2, "Kimani");
//        secondRanger.add();
//
//        assertEquals(Ranger.findById(secondRanger.getRanger_id()), secondRanger);
//    }

//    @Test
//    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList(){
//        testRanger.add();
//        firstSighting.save();
//        secondSighting.save();
//        Sighting[] sightings = new Sighting[]{firstSighting, secondSighting};
//        assertTrue(testRanger.getSightings().containsAll(Arrays.asList(sightings)));
//    }


}
