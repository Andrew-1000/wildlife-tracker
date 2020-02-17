package models;

public class Sighting {
    private int sighting_id;
    private String location;
    private int ranger_id;
    private int animal_id;

    public Sighting(int sighting_id, String location, int ranger_id, int animal_id) {
        this.sighting_id = sighting_id;
        this.location = location;
        this.ranger_id = ranger_id;
        this.animal_id = animal_id;
    }


    public int getSighting_id() {
        return sighting_id;
    }

    public String getLocation() {
        return location;
    }

    public int getRanger_id() {
        return ranger_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }


}
