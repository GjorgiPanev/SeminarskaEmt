package mk.ukim.finki.emt.project.userreservationmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.DomainObjectId;

public class ReservationId extends DomainObjectId {

    private ReservationId() {
        super(ReservationId.randomId(ReservationId.class).getId());
    }

    public ReservationId(@NonNull String id) {
        super(id);
    }

    public static ReservationId of(String id) {
        return new ReservationId(id);
    }
}
