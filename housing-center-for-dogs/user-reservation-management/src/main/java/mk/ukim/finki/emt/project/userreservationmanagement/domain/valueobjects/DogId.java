package mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects;

import mk.ukim.finki.emt.project.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class DogId extends DomainObjectId {
    private DogId() {
        super(DogId.randomId(DogId.class).getId());
    }

    public DogId(String id) {
        super(id);
    }
    public static DogId of(String uuid) {
        DogId d = new DogId(uuid);
        return d;
    }

}
