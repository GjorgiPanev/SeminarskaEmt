package mk.ukim.finki.emt.project.userreservationmanagement.xport.resource;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.UserId;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Dog;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.project.userreservationmanagement.services.UserService;
import mk.ukim.finki.emt.project.userreservationmanagement.xport.client.DogClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/dogs")
@CrossOrigin(origins = "http://localhost:3000")
public class DogResource {
     private final DogClient dogService;
     private final UserService reservationService;

    @GetMapping
    public List<Dog> getAll() {
        return dogService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> reserveById(@PathVariable String id) {
        UserId userId = this.reservationService.findByEmail(new Email("laki_laki@gmail.com")).getId();
        try {
           Reservation reservation = this.reservationService.createReservation(userId, this.dogService.findDogById(id)).get();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.dogService.changeDogStatus(id));
    }
}
