package mk.ukim.finki.emt.project.userreservationmanagement.domain.exceptions;


public class UserCanNotCreateReservation extends RuntimeException{
    public UserCanNotCreateReservation() {
        super("User can not create reservation");
    }
}
