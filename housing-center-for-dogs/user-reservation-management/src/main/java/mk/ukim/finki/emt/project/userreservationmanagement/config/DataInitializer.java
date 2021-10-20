package mk.ukim.finki.emt.project.userreservationmanagement.config;

import lombok.AllArgsConstructor;

import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.User;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.repository.UserRepository;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.JobStatus;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.ContactNumber;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final UserRepository userRepository;

    @PostConstruct
    public void initData() {
        User user1 = User.build(new Email("magi_magi@gmail.com"), "Magi", new ContactNumber("071111222"), "female",22,true,JobStatus.of("employee"));
        User user2 = User.build(new Email("laki_laki@gmail.com"), "Laki", new ContactNumber("071111222"), "male",65,true,JobStatus.of("employee"));
        if (userRepository.findAll().isEmpty()) {
            userRepository.saveAll(Arrays.asList(user1, user2));
        }
    }
}