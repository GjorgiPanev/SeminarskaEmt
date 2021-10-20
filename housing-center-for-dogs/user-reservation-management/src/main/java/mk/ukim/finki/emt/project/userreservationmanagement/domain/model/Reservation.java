package mk.ukim.finki.emt.project.userreservationmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.DogId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity<ReservationId> {
    // more reservations can be created from one user
    @ManyToOne
    private User user;
    private LocalDateTime reservationDate;
    private LocalDateTime housingDate;
    @AttributeOverride(name = "id", column = @Column(name = "dog_id", nullable = false))
    private DogId dogId;


    protected Reservation() {
        super(ReservationId.randomId(ReservationId.class));
    }

    public static Reservation build(User user, LocalDateTime reservationDate, LocalDateTime housingDate, DogId dogId) {
        Reservation reservation = new Reservation();
        reservation.user = user;
        reservation.reservationDate = reservationDate;
        reservation.housingDate = housingDate;
        reservation.dogId = dogId;
        return reservation;
    }
}
