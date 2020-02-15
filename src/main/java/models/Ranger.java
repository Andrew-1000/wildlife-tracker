package models;


public class Ranger {
    private int ranger_id;
    private String ranger_name;


    public Ranger(int ranger_id, String ranger_name) {
        this.ranger_id = ranger_id;
        this.ranger_name = ranger_name;
    }

    public int getRanger_id() {
        return ranger_id;
    }
    public String getRanger_name() {
        return ranger_name;
    }
    public void setRanger_id(int ranger_id) {
        this.ranger_id = ranger_id;
    }
//
    public void setRanger_name(String ranger_name) {
        this.ranger_name = ranger_name;
    }





}
