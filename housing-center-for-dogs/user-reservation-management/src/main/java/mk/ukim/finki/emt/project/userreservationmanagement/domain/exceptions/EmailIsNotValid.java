package mk.ukim.finki.emt.project.userreservationmanagement.domain.exceptions;

public class EmailIsNotValid extends RuntimeException{
    public EmailIsNotValid() {
        super("Email is not in valid format");
    }
}
