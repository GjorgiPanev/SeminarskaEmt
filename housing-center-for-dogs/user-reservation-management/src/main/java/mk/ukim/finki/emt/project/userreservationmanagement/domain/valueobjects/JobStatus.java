package mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class JobStatus implements ValueObject {
    private final String jobStatus;

    protected JobStatus() {
        this.jobStatus = "unknown";
    }

    public JobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public static JobStatus of (String jobStatus) {
        return new JobStatus(jobStatus);
    }
}
