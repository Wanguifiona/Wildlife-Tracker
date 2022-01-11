package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();



    @Test
    public void Endangered_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone");
        assertEquals(true, testEndangered instanceof EndangeredAnimal);
    }
    @Test
    public void Endangered_InstantiatesWithName_Elephant() {
        EndangeredAnimal testEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        assertEquals("Elephant", testEndangered.getName());
    }
    @Test
    public void Endangered_InstantiatesWithHealth_Ill() {
        EndangeredAnimal testEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        assertEquals("Ill", testEndangered.getHealth());
    }
    @Test
    public void Endangered_InstantiatesWithType_Endangered() {
        EndangeredAnimal testEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        assertEquals("Endangered", testEndangered.getType());
    }
    @Test
    public void Endangered_InstantiatesWithAge_Young() {
        EndangeredAnimal testEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        assertEquals("Zone A", testEndangered.getAge());
    }
//
    @Test
    public void equals_returnsTrueIfRangerNameAreSame_true() {
        EndangeredAnimal testEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        EndangeredAnimal anotherEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        assertTrue(testEndangered.equals(anotherEndangered));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Endangered() {
        EndangeredAnimal testEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        testEndangered.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangered));
    }
    @Test
    public void all_returnsAllInstancesOfEndangered_true() {
        EndangeredAnimal firstEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        firstEndangered.save();
        EndangeredAnimal secondEndangered = EndangeredAnimal.all().get(0);
        secondEndangered.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangered));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangered));
    }
    @Test
    public void save_assignsIdToEndangered() {
        EndangeredAnimal unsavedEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        unsavedEndangered.save();
        EndangeredAnimal savedEndangered = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangered.getId(), unsavedEndangered.getId());
    }
    @Test
    public void find_returnsEndangeredWithSameId_secondEndangered() {
        EndangeredAnimal firstEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        firstEndangered.save();
        EndangeredAnimal secondEndangered = new EndangeredAnimal("Elephant", "Ill",  "Young", "Zone A");
        secondEndangered.save();
        assertEquals(Animals.find(secondEndangered.getId()), secondEndangered);
    }


}