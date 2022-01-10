package models;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int id;
    private String rangerName;
    private int animalId;
    private String location;
    private Timestamp lastSeen;


    public Sighting(String rangerName,int animalId, String location ){
        this.rangerName = rangerName;
        this.animalId = animalId;
        this.location = location;

    }
    public String getRangerName() {
        return rangerName;
    }
    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }
    public Timestamp getLastSeen() {
        return lastSeen;
    }
    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getRangerName().equals(newSighting.getRangerName()) &&
                    this.getAnimalId() == newSighting.getAnimalId() &&
                    this.getLocation().equals(newSighting.getLocation());


        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRangerName(),getAnimalId(), getLocation());
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sighting (animalId, rangerName, location, lastSeen) VALUES (:animalId, :rangerName, :location, :now()";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("location", this.location)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> all() {
        String sql = "SELECT * FROM sighting";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sighting where id=:id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }

}
