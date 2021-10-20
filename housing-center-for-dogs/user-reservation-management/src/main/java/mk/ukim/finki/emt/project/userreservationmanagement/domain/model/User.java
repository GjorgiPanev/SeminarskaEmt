package mk.ukim.finki.emt.project.userreservationmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.ContactNumber;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.JobStatus;

import javax.persistence.*;

@Getter
@Entity
@Table(name="[USER]")
public class User extends AbstractEntity<UserId> {
    // value object
    private Email email;
    private String name;
    // value object
    private ContactNumber contactNumber;
    private String gender;
    private Integer age;
    private Boolean garden;
    // value object
    private JobStatus jobStatus;

    protected User() {
        super(UserId.randomId(UserId.class));
    }

    public static User build(Email email, String name, ContactNumber contactNumber, String gender, Integer age, Boolean garden, JobStatus jobStatus) {
        User user = new User();
        user.email = email;
        user.name = name;
        user.contactNumber = contactNumber;
        user.gender = gender;
        user.age = age;
        user.garden = garden;
        user.jobStatus = jobStatus;
        return user;
    }
    public User editUserInfo(Email email, String name, ContactNumber contactNumber, String gender, Integer age, Boolean garden, JobStatus jobStatus) {
        this.email = email;
        this.name = name;
        this.contactNumber = contactNumber;
        this.gender = gender;
        this.age = age;
        this.garden = garden;
        this.jobStatus = jobStatus;
        return this;
    }
}
