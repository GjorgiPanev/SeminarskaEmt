package mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.ValueObject;

@Getter
public class Dog implements ValueObject {
    private final DogId id;
    private final String dogName;
    private final Race race;
    private final Integer age;
    private final String gender;
    private final Boolean availableStatus;

    private Dog() {
        this.id = DogId.randomId(DogId.class);
        this.dogName = "";
        this.race = Race.valueOf("OTHER");
        this.age = 0;
        this.gender = "unknown";
        this.availableStatus = false;
    }

    @JsonCreator
    public Dog(@JsonProperty("id") DogId id,
               @JsonProperty("dogName") String name,
               @JsonProperty("race") Race race,
               @JsonProperty("age") Integer age,
               @JsonProperty("gender") String gender,
               @JsonProperty("availableStatus") Boolean availableStatus) {
        this.id = id;
        this.dogName = name;
        this.race = race;
        this.age = age;
        this.gender = gender;
        this.availableStatus = availableStatus;
    }

}
