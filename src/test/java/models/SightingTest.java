package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Sighting testSighting = new Sighting("Mike", 1,"Zone A");
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void getRangerName_sightingInstantiatesWithrangerName_true() {
        Sighting testSighting = new Sighting("Mike", 1,"Zone A");
        assertEquals("Mike", testSighting.getRangerName());
    }
    @Test
    public void getAnimalId_sightingInstantiatesWithanimalId_true() {
        Sighting testSighting = new Sighting("Mike", 1,"Zone A");
        assertEquals(1, testSighting.getAnimalId());
    }
    @Test
    public void getLocation_sightingInstantiatesWithlocation_true() {
        Sighting testSighting = new Sighting("Mike", 1,"Zone A");
        assertEquals("Zone A", testSighting.getLocation());
    }
    @Test
    public void equals_returnsTrueIfRangerNameAreSame_true() {
        Sighting testSighting = new Sighting("Mike", 1,"Zone A");
        Sighting anotherSighting = new Sighting("Mike", 1,"Zone A");
        assertTrue(testSighting.equals(anotherSighting));
    }
    @Test
    public void save_successfullyAddsSightingToDatabase_List() {
        Sighting testSighting = new Sighting("Mike", 1,"Zone A");
        testSighting.save();
        assertTrue(Sighting.all().get(0).equals(testSighting));
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Sighting firstSighting = new Sighting("Mike", 1, "Zone A");
        firstSighting.save();
        Sighting secondSighting = new Sighting("Paul", 2,"Near the river");
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));

    }
    @Test
    public void save_assignsIdToObject() {
        Sighting testSighting = new Sighting("Mike",1, "Zone A");
        testSighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(testSighting.getAnimalId(), savedSighting.getId());
    }
    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        Sighting firstSighting = new Sighting("Mike", 1, "Zone A");
        firstSighting.save();
        Sighting secondSighting = new Sighting("Paul", 2, "Near the river");
        secondSighting.save();
        assertEquals(Animal.find(secondSighting.getId()), secondSighting);
    }


}