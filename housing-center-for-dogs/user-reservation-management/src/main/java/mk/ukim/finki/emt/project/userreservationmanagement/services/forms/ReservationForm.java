package mk.ukim.finki.emt.project.userreservationmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.User;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.DogId;
import java.time.LocalDateTime;

@Data
public class ReservationForm {
    private User user;
    private LocalDateTime reservationDate;
    private LocalDateTime housingDate;
    private DogId dogId;
}
