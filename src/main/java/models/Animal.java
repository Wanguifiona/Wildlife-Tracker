


package models;

import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Animal implements DatabaseManagement{

    private String name;
    private int id;

    public Animal(String name){
        this.name = name;

    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animal (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Animal> all() {
        String sql = "SELECT * FROM animal";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }
    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animal where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
//    public static List<Object> getAnimals() {
//        List<Object> allAnimals = new ArrayList<Object>();
//
//        try(Connection con = DB.sql2o.open()) {
//            String sqlFire = "SELECT * FROM animal WHERE id=:id AND type='animal';";
//            List<Animal> animals = con.createQuery(sqlFire)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(Animal.class);
//            allAnimals.addAll(animals);
//
//            String sqlWater = "SELECT * FROM animal WHERE id=:id AND type='endangered-animal';";
//            List<EndangeredAnimal> endangeredAnimals = con.createQuery(sqlWater)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(EndangeredAnimal.class);
//            allAnimals.addAll(endangeredAnimals);
//        }
//
//        return allAnimals;
//    }

//        public static List<Sighting> getSightings() {
//            try (Connection con = DB.sql2o.open()) {
//                String sql = "SELECT * FROM sighting WHERE animalId=:id";
//                return con.createQuery(sql)
//                        .addParameter("id", this.id)
//                        .executeAndFetch(Sighting.class);
//            }
//        }
}