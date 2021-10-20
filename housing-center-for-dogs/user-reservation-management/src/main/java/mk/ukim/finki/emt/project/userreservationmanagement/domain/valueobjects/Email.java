package mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Getter
@Embeddable
public class Email implements ValueObject {
    private final String email;

    protected Email() {
        this.email = "";
    }

    public Email (String email) {
        this.email = email;
    }

    public static boolean isValid(String emailForCheck) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (emailForCheck == null)
            return false;
        return pat.matcher(emailForCheck).matches();
    }
}
