package models;

import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Jaguar");
        assertEquals(true, testAnimal instanceof Animal);
    }
    @Test
    public void getName_animalInstantiatesWithName_Jaguar() {
        Animal testAnimal = new Animal("Jaguar");
        assertEquals("Jaguar", testAnimal.getName());
    }
    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        Animal firstAnimal = new Animal("Jaguar");
        Animal anotherAnimal = new Animal("Jaguar");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Person() {
        Animal testAnimal = new Animal("Jaguar");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = new Animal("Jaguar");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Giraffe");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Jaguar");
        testAnimal.save();
        Animal savedPerson = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedPerson.getId());
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Jaguar");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Giraffe");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

//    @Test
//    public void getAnimals_retrievesAllAnimalssFromDatabase_animalsList() {
//        Animal testAnimal = new Animal("Jaguar");
//        testAnimal.save();
//        Sighting firstSighting  = new Sighting("Limuru", testAnimal.getId());
//        testAnimal.save();
//        Sighting secondSighting = new Sighting("Nairobi", testAnimal.getId());
//        testAnimal.save();
//        Object[] monsters = new Object[] { firstSighting, secondSighting };
//        assertTrue(testAnimal.getSightings().containsAll(Arrays.asList(monsters)));
//    }



}