package mk.ukim.finki.emt.project.dogsmanagement.services;

import mk.ukim.finki.emt.project.dogsmanagement.domain.model.Dog;
import mk.ukim.finki.emt.project.dogsmanagement.domain.model.DogId;
import mk.ukim.finki.emt.project.dogsmanagement.services.form.DogForm;
import java.util.List;
import java.util.Optional;

public interface DogService {
    List<Dog> findAllDogs();
    Optional<Dog> findById(DogId dogId);
    Dog findByIdWithoutOptional(DogId dogId);
    Optional<Dog> createDogEntityForHousing(DogForm dogForm);
    Optional<Dog> editDogEntityForHousing(DogId dogId, DogForm form);
    void deleteDogEntity(DogId id);
    Dog changeStatus(DogId dogId, Boolean status);
}
