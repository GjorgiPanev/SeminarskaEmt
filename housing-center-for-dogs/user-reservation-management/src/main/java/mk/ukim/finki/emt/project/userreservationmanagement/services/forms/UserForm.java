package mk.ukim.finki.emt.project.userreservationmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.ContactNumber;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.JobStatus;

import javax.validation.constraints.NotBlank;

@Data
public class UserForm {
    @NotBlank(message = "User email must not be blank")
    private Email email;
    @NotBlank(message = "User name must not be blank")
    private String name;
    @NotBlank(message = "User number must not be blank")
    private ContactNumber contactNumber;
    private String gender;
    private Integer age;
    @NotBlank(message = "User garden status must not be blank")
    private Boolean garden;
    @NotBlank(message = "User job status must not be blank")
    private JobStatus jobStatus;
}
