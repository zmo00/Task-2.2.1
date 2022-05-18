package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

//    default void add(User user, hiber.model.Car car) {
//        car.setOwner(user);
//        user.setCar(car);
//        this.add(user);
//    }

    List<User> listUsers();
    List<User> userWithCar(String model, int series);

}
