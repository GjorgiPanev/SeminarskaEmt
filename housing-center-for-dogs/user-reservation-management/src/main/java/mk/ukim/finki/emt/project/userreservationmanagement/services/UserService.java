package mk.ukim.finki.emt.project.userreservationmanagement.services;

import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.User;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.UserId;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Dog;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.DogId;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.project.userreservationmanagement.services.forms.UserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    User findById(UserId userId);
    User findByEmail(Email email);
    User createUser(UserForm userForm);
    User editUser(UserId userId, UserForm userForm);
    void deleteUser(UserId id);
    Optional<Reservation> createReservation(UserId userId, Dog dog);
    void removeReservation(UserId userId, Dog dog);
    List<Reservation> findAllReservations();
    void removeReservationForStatusChanged(DogId dogId);
}
