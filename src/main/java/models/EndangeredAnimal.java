package models;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Wildlife implements DatabaseManagement {
    public static final String ANIMAL_TYPE = "endangered";


    public EndangeredAnimal(String name, String health, String type, String age) {
        this.name = name;
        this.health = health;
        this.type = ANIMAL_TYPE;
        this.age = age;

//        if (name.isEmpty() || health.isEmpty() || age.isEmpty()){
//            throw new IllegalArgumentException("Please enter all input fields.");
//        }
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getHealth() {
//        return health;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public String getRanger() {
//        return ranger;
//    }
//    public int getId() {
//        return id;
//    }

    @Override
    public boolean equals(Object otherAnimal ){
        if (!(otherAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newAnimal = (EndangeredAnimal) otherAnimal;
            return this.getAge().equals( newAnimal.getAge()) &&
                    this.getHealth().equals(newAnimal.getHealth()) &&
                    this.getAge().equals(newAnimal.getType());
        }
    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(getName(), getId());
//    }
////
//    @Override
//    public void save() {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "INSERT INTO animal (name, type, health, age, location, ranger) VALUES (:name, :type, :health, :age, :location, :ranger)";
//            this.id = (int) con.createQuery(sql, true)
//                    .addParameter("name", this.name)
//                    .addParameter("type", this.type)
//                    .addParameter("health", this.health)
//                    .addParameter("age", this.age)
//                    .addParameter("location", this.location)
//                    .addParameter("ranger", this.ranger)
//                    .executeUpdate()
//                    .getKey();
//        }
//    }
    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type = 'endangered';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }
//    public List<Sighting> getSighting() {
//        try (Connection con = DB.sql2o.open()) {
//            String sql = "SELECT * FROM sighting WHERE animalId=:id";
//            return con.createQuery(sql)
//                    .addParameter("id", this.id)
//                    .executeAndFetch(Sighting.class);
//        }
//
}
