package mk.ukim.finki.emt.project.sharedkernel.infra;

import mk.ukim.finki.emt.project.sharedkernel.domain.events.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
