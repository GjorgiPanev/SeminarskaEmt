package mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class ContactNumber implements ValueObject {
    private final String number;

    protected ContactNumber() {
        this.number = "";
    }
    public ContactNumber(String number) {
        this.number = number;
    }
}
