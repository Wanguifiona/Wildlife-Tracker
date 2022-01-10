package models;

public class Animal  {
    private String name;
    private int id;

    public Animal(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
