package mk.ukim.finki.emt.project.dogsmanagement;

import mk.ukim.finki.emt.project.dogsmanagement.domain.model.Dog;
import mk.ukim.finki.emt.project.dogsmanagement.domain.repository.DogRepository;
import mk.ukim.finki.emt.project.dogsmanagement.domain.valueobjects.Race;
import mk.ukim.finki.emt.project.dogsmanagement.services.DogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class DogsManagementTest {
    @Autowired
    private DogService dogService;
    @Autowired DogRepository dogRepository;


    private static Dog newDog() {
        return Dog.build("HanaMana", Race.SHAR_MOUNTAINEER, 2, "female", true);
    }

    @Test
    public void testDogStatusChanged() {
        Dog dog = DogsManagementTest.newDog();
        dogRepository.save(dog);
        dogService.changeStatus(dog.getId(),false);
        Assertions.assertEquals(dog.getAvailableStatus(), false);

    }
}

