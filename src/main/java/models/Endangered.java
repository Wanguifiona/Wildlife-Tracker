package models;

import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Endangered implements DatabaseManagement {
    private int id;
    private String name;
    private String health;
    private String type;
    private String age;
    private String location;
    private String ranger;

    public Endangered(String name, String health, String type, String age, String location, String ranger) {
        this.name = name;
        this.health = health;
        this.type = type;
        this.age = age;
        this.location = location;
        this.ranger = ranger;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getRanger() {
        return ranger;
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherEndangered ){
        if (!(otherEndangered instanceof Endangered)) {
            return false;
        } else {
            Endangered newEndangered = (Endangered) otherEndangered;
            return getId() == newEndangered.getId() &&
            Objects.equals(getName(), newEndangered.getName());
//                    this.getAge().equals( newEndangered.getAge()) &&
//                    this.getLocation().equals(newEndangered.getLocation()) &&
//                    this.getHealth().equals(newEndangered.getHealth()) &&
//                    this.getType().equals(newEndangered.getType()) &&
//                    this.getRanger().equals(newEndangered.getRanger());


        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
//
    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, danger, health, age, location, ranger) VALUES (:name, :danger, :health, :age, :location, :ranger)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .addParameter("ranger", this.ranger)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Endangered> all() {
        String sql = "SELECT * FROM animal";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Endangered.class);
        }
    }
    public static Endangered find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animal where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Endangered.class);
        }
    }
//    public List<Sighting> getSighting() {
//        try (Connection con = DB.sql2o.open()) {
//            String sql = "SELECT * FROM sighting WHERE animalId=:id";
//            return con.createQuery(sql)
//                    .addParameter("id", this.id)
//                    .executeAndFetch(Sighting.class);
//        }
//    }
}
