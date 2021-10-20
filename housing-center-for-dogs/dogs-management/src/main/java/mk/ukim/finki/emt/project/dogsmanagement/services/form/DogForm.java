package mk.ukim.finki.emt.project.dogsmanagement.services.form;

import lombok.Data;
import mk.ukim.finki.emt.project.dogsmanagement.domain.valueobjects.Race;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DogForm {
    @NotBlank(message = "Dog name must not be blank")
    private String dogName;
    @NotNull
    private Race race;
    private Integer age;
    @NotBlank(message = "Dog gender must not be blank")
    private String gender;
    @NotBlank(message = "Status must not be blank")
    private Boolean availableStatus;
}
