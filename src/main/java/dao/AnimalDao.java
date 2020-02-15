package dao;
import java.util.List;

import models.Animal;

public interface AnimalDao {
    List<Animal> getAll();

    Animal findById(int animal_id);
    void add (int animal_id, String animal_name, String health, String age, String endangered);
}
