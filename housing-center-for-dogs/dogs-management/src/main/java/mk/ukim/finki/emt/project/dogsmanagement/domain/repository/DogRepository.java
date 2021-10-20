package mk.ukim.finki.emt.project.dogsmanagement.domain.repository;

import mk.ukim.finki.emt.project.dogsmanagement.domain.model.Dog;
import mk.ukim.finki.emt.project.dogsmanagement.domain.model.DogId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, DogId> {
}
