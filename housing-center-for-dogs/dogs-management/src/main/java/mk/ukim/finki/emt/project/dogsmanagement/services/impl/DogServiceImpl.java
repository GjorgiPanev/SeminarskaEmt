package mk.ukim.finki.emt.project.dogsmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.dogsmanagement.domain.exceptions.DogNotFoundException;
import mk.ukim.finki.emt.project.dogsmanagement.domain.model.Dog;
import mk.ukim.finki.emt.project.dogsmanagement.domain.model.DogId;
import mk.ukim.finki.emt.project.dogsmanagement.domain.repository.DogRepository;
import mk.ukim.finki.emt.project.dogsmanagement.services.DogService;
import mk.ukim.finki.emt.project.dogsmanagement.services.form.DogForm;
import mk.ukim.finki.emt.project.sharedkernel.domain.events.dogstatus.OnStatusChangedEvent;
import mk.ukim.finki.emt.project.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;
    private final DomainEventPublisher domainEventPublisher;


    @Override
    public List<Dog> findAllDogs() {
        return this.dogRepository.findAll();
    }

    @Override
    public Optional<Dog> findById(DogId dogId) {
        return this.dogRepository.findById(dogId);
    }

    @Override
    public Dog findByIdWithoutOptional(DogId dogId) {
        return this.dogRepository.findById(dogId).orElseThrow(DogNotFoundException::new);
    }

    @Override
    public Optional<Dog> createDogEntityForHousing(DogForm dogForm) {
        Dog dog = Dog.build(dogForm.getDogName(), dogForm.getRace(), dogForm.getAge(), dogForm.getGender(), dogForm.getAvailableStatus());
        return Optional.of(this.dogRepository.save(dog));
    }

    @Override
    public Optional<Dog> editDogEntityForHousing(DogId dogId, DogForm form) {
        Dog dog = this.findByIdWithoutOptional(dogId);
        return Optional.of(this.dogRepository.save(dog.editDogInfo(form.getDogName(), form.getRace(), form.getAge(), form.getGender(), form.getAvailableStatus())));
    }

    @Override
    public void deleteDogEntity(DogId id) {
        this.dogRepository.deleteById(id);
    }

    @Override
    public Dog changeStatus(DogId dogId, Boolean status) {
        Dog dog = this.findByIdWithoutOptional(dogId);
        dog.changeDogStatus(status);
        this.dogRepository.save(dog);
//        if (!status) {
//          domainEventPublisher.publish(new OnStatusChangedEvent(dogId.getId(), "Dog status changed to unavailable"));
//        }
        return dog;
    }
}
