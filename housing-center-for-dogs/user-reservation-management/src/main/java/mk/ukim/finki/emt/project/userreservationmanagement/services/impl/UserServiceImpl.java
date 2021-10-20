package mk.ukim.finki.emt.project.userreservationmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.exceptions.UserCanNotCreateReservation;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.User;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.UserId;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.repository.ReservationRepository;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.repository.UserRepository;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.*;
import mk.ukim.finki.emt.project.userreservationmanagement.services.UserService;
import mk.ukim.finki.emt.project.userreservationmanagement.services.forms.UserForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(UserId userId) {
        return this.userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User findByEmail(Email email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public User createUser(UserForm userForm) {
        if(Email.isValid(userForm.getEmail().getEmail())) {
            User user = User.build(userForm.getEmail(), userForm.getName(), userForm.getContactNumber(), userForm.getGender(), userForm.getAge(), userForm.getGarden(), userForm.getJobStatus());
            return this.userRepository.save(user);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public User editUser(UserId userId, UserForm userForm) {
        User user = this.findById(userId);
        return userRepository.save(user.editUserInfo(userForm.getEmail(), userForm.getName(), userForm.getContactNumber(), userForm.getGender(), userForm.getAge(), userForm.getGarden(), userForm.getJobStatus()));
    }

    @Override
    public void deleteUser(UserId id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> createReservation(UserId userId, Dog dog) {
        User user = this.findById(userId);
        if (!dog.getAvailableStatus()) {
            throw new UserCanNotCreateReservation();
        }
        if (user.getJobStatus().getJobStatus().equals("EMPLOYEE") && user.getAge()>=18) {
            if (dog.getRace().equals(Race.valueOf("SHAR_MOUNTAINEER"))) {
                if (!user.getGarden()) {
                    throw new UserCanNotCreateReservation();
                }
            }
            Reservation reservation = Reservation.build(user, LocalDateTime.now(), LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth() + 1, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), dog.getId());
            return Optional.of(this.reservationRepository.save(reservation));
        }
        throw new UserCanNotCreateReservation();
    }

    @Override
    public void removeReservation(UserId userId, Dog dog) {
        User user = this.findById(userId);
        this.reservationRepository.delete(this.reservationRepository.findReservationByUserAndDogId(user, dog.getId()));
    }

    @Override
    public List<Reservation> findAllReservations() {
        return this.reservationRepository.findAll();
    }

    @Override
    public void removeReservationForStatusChanged(DogId dogId) {
        List<Reservation> allReservationsForCurrentDog = this.reservationRepository.findAllByDogId(dogId);
        for (Reservation r: allReservationsForCurrentDog) {
            this.reservationRepository.delete(r);
        }
    }
}
