package mk.ukim.finki.emt.project.userreservationmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.DomainObjectId;

public class UserId extends DomainObjectId {

    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(@NonNull String id) {
        super(id);
    }

    public static UserId of(String id) {
        return new UserId(id);
    }
}
