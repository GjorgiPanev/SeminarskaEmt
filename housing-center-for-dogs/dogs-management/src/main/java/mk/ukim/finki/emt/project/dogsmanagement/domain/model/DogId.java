package mk.ukim.finki.emt.project.dogsmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.DomainObjectId;

public class DogId extends DomainObjectId {

    private DogId() {
        super(DogId.randomId(DogId.class).getId());
    }

    public DogId(@NonNull String id) {
        super(id);
    }

    public static DogId of(String id) {
        return new DogId(id);
    }
}
