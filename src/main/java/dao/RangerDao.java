package dao;

import models.Ranger;

import java.util.List;

public interface RangerDao {

     List<Ranger> getAll();

    void add(int ranger_id, String ranger_name);

    Ranger find(int ranger_id);


}
