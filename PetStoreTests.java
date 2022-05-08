package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class PetStoreTests {
private Animal animal;
private PetStore petStore;

@Before
    public void setUp(){
    animal = new Animal("dog", 20, 200);
    petStore = new PetStore();
    petStore.addAnimal(animal);
}
@Test(expected = UnsupportedOperationException.class)
public void testGetAnimalsShouldThrow(){
    petStore.getAnimals().remove(animal);
}
    @Test
    public void testGetCount(){
        Assert.assertEquals(petStore.getCount(),1);
    }
    @Test
    public void testFindAllAnimalsWithMaxKilograms(){
    Animal animal1 = new Animal("cat", 10, 100);
    petStore.addAnimal(animal1);
        List<Animal> animalsList =new ArrayList<>();
        animalsList.add(animal1);
        animalsList.add(this.animal);
       List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(9);
        Assert.assertEquals(animalsList.size(), actual.size());

    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddAnimalThrow(){
        Animal animal1 = null;
        petStore.addAnimal(animal1);
    }

    @Test
    public void testGetTheMostExpensiveAnimal(){
        Animal animal1 = new Animal("cat", 10, 100);
        petStore.addAnimal(animal1);

       Animal animal2 = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals(animal2.getPrice(), 200,0.00);
    }
    @Test
    public void testFindAllAnimalBySpecie(){
        Animal animal1 = new Animal("dog", 10, 100);
        petStore.addAnimal(animal1);

        List<Animal> actual = this.petStore.findAllAnimalBySpecie("dog");
Assert.assertEquals(actual.size(), 2);
    }

    @Test
    public void testGetAge(){
    this.animal.setAge(5);
    Assert.assertEquals(this.animal.getAge(), 5);
    }
}

