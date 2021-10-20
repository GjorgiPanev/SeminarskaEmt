package mk.ukim.finki.emt.project.dogsmanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.dogsmanagement.domain.model.Dog;
import mk.ukim.finki.emt.project.dogsmanagement.domain.model.DogId;
import mk.ukim.finki.emt.project.dogsmanagement.services.DogService;
import mk.ukim.finki.emt.project.dogsmanagement.services.form.DogForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dogs")
@CrossOrigin(origins = "http://localhost:3000")
public class DogRestController {
     private final DogService dogService;

    @GetMapping
    public List<Dog> getAll() {
        return dogService.findAllDogs();
    }

    @PostMapping("/add")
    public ResponseEntity<Dog> create(@RequestBody DogForm dogForm) {
        return this.dogService.createDogEntityForHousing(dogForm).map(dog -> ResponseEntity.ok().body(dog))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> findById(@PathVariable String id) {
        DogId dogId = new DogId(id);
        return this.dogService.findById(dogId)
                .map(dog -> ResponseEntity.ok().body(dog))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Dog> edit(@PathVariable String id,
                                                  @RequestBody DogForm dogForm) {
        DogId dogId = new DogId(id);
        return this.dogService.editDogEntityForHousing(dogId,dogForm)
                .map(attraction -> ResponseEntity.ok().body(attraction))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        DogId dogId = new DogId(id);
        this.dogService.deleteDogEntity(dogId);
        if (this.dogService.findById(dogId).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/reserved/{id}")
    public ResponseEntity<Dog> reserveDogChangeStatus(@PathVariable String id) {
        DogId dogId = new DogId(id);
        Dog dog = dogService.changeStatus(dogId, false);
        return ResponseEntity.ok().body(dog);
    }
}
