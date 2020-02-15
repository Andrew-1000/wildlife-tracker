package models;


public class Animal {
   private int animal_id;
    private String animal_name;
    private String health;
    private int age;
    private boolean endangered;


    public Animal(int animal_id, String animal_name, String health, int age, boolean endangered) {
        this.animal_id = animal_id;
        this.animal_name = animal_name;
        this.health = health;
        this.age = age;
        this.endangered = endangered;

    }



    public String getAnimal_name() {
        return animal_name;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public String getHealth() {
        return health;
    }

    public int getAge() {
        return age;
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }
}




