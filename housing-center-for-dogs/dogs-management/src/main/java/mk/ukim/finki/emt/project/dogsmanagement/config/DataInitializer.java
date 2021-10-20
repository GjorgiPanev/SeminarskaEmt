package mk.ukim.finki.emt.project.dogsmanagement.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.dogsmanagement.domain.model.Dog;
import mk.ukim.finki.emt.project.dogsmanagement.domain.repository.DogRepository;
import mk.ukim.finki.emt.project.dogsmanagement.domain.valueobjects.Race;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final DogRepository dogRepository;

    @PostConstruct
    public void initData() {
        Dog dog1 = Dog.build("Hana", Race.SHAR_MOUNTAINEER, 2, "female", true);
        Dog dog2 = Dog.build("Miki", Race.MALTESE, 4, "male", true);
        if (dogRepository.findAll().isEmpty()) {
            dogRepository.saveAll(Arrays.asList(dog1, dog2));
        }
    }
}