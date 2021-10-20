package mk.ukim.finki.emt.project.dogsmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.project.dogsmanagement.domain.valueobjects.Race;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="dog")
public class Dog extends AbstractEntity<DogId> {

    private String dogName;
    // value object - enum
    @Enumerated(value = EnumType.STRING)
    private Race race;
    private Integer age;
    private String gender;
    private Boolean availableStatus;

    protected Dog() {
        super(DogId.randomId(DogId.class));
    }

    public static Dog build(String dogName, Race race, Integer age, String gender, Boolean availableStatus) {
        Dog dog = new Dog();
        dog.dogName = dogName;
        dog.race = race;
        dog.age = age;
        dog.gender = gender;
        dog.availableStatus = availableStatus;
        return dog;
    }

    public Dog editDogInfo(String dogName, Race race, Integer age, String gender, Boolean availableStatus) {
        this.dogName = dogName;
        this.race = race;
        this.age = age;
        this.gender = gender;
        this.availableStatus = availableStatus;
        return this;
    }

    public Dog changeDogStatus(Boolean availableStatus) {
        this.availableStatus = availableStatus;
        return this;
    }

}
