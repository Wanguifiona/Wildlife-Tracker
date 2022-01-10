
package models;
import org.sql2o.*;

import java.util.List;
import java.util.Objects;


public class Animal{
//     implements DatabaseManagement
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
            String sql = "INSERT INTO persons (name, email) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Animal> all() {
    String sql = "SELECT * FROM persons";
    try(Connection con = DB.sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Animal.class);
    }
}
    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM persons where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }

}
