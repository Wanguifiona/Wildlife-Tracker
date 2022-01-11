package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Endangered_instantiatesCorrectly_true() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        assertEquals(true, testEndangered instanceof Endangered);
    }
    @Test
    public void getName_InstantiatesWithName_Mike() {
        Endangered testEndangered = new Endangered("Mike", "ll", "Endangered", "Young", "Zone A", "Mike");
        assertEquals("Mike", testEndangered.getName());
    }
    @Test
    public void gethealth_InstantiatesWithHealth_Ill() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        assertEquals("Ill", testEndangered.getHealth());
    }
    @Test
    public void getType_InstantiatesWithType_Endangered() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        assertEquals("Endangered", testEndangered.getType());
    }
    @Test
    public void getAge_InstantiatesWithAge_Young() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        assertEquals("Young", testEndangered.getAge());
    }
    @Test
    public void getLocation_InstantiatesWithLocation_ZoneA() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        assertEquals("Zone A", testEndangered.getLocation());
    }
    @Test
    public void getRanger_InstantiatesWithRanger_Mike() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        assertEquals("Mike", testEndangered.getRanger());
    }
    @Test
    public void equals_returnsTrueIfRangerNameAreSame_true() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        Endangered anotherEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        assertTrue(testEndangered.equals(anotherEndangered));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Endangered() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        testEndangered.save();
        assertTrue(Endangered.all().get(0).equals(testEndangered));
    }
    @Test
    public void all_returnsAllInstancesOfEndangered_true() {
        Endangered firstEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        firstEndangered.save();
        Endangered secondEndangered = new Endangered("Jules", "okay", "Endangered", "Old", "Near the river", "Jules");
        secondEndangered.save();
        assertEquals(true, Endangered.all().get(0).equals(firstEndangered));
        assertEquals(true, Endangered.all().get(1).equals(secondEndangered));
    }
    @Test
    public void save_assignsIdToObject() {
        Endangered testEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        testEndangered.save();
        Endangered savedEndangered = Endangered.all().get(0);
        assertEquals(testEndangered.getId(), savedEndangered.getId());
    }
    @Test
    public void find_returnsEndangeredWithSameId_secondEndangered() {
        Endangered firstEndangered = new Endangered("Mike", "Ill", "Endangered", "Young", "Zone A", "Mike");
        firstEndangered.save();
        Endangered secondEndangered = new Endangered("Jules", "okay", "Endangered", "Old", "Near the river", "Jules");
        secondEndangered.save();
        assertEquals(Animal.find(secondEndangered.getId()), secondEndangered);
    }


}