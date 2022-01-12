package models;

import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://ec2-3-227-15-75.compute-1.amazonaws.com:5432/d7kt9nr4lpvou9", "brphmeewosowzv", "c44a05b260a3b5cd50bb630349ff7ccab172071c590af306441854372145f8df");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalQuery = "DELETE FROM animals *;";
            String deleteSightingQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingQuery).executeUpdate();
        }
    }
}