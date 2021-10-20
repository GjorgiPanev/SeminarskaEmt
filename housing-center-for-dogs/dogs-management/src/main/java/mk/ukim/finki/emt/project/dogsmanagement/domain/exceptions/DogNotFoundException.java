package mk.ukim.finki.emt.project.dogsmanagement.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogNotFoundException extends RuntimeException{
    public DogNotFoundException() {
        super("Dog entity not found exception");
    }
}
