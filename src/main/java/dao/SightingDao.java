package dao;

import models.Ranger;
import models.Sighting;

import java.util.List;

public interface SightingDao {
    List<Sighting> getAll();

    Sighting find(int sighting_id);
    void add(int sighting_id, String location, int animal_id, int ranger_id);
}
