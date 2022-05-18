package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User mike = new User("Mike", "Zhurikov", "zmo00@yandex.ru");
        Car mikeCar = new Car("Toyota", 1);
        mikeCar.setOwner(mike);
        mike.setCar(mikeCar);
        userService.add(mike);

        User alex = new User("Alex", "Fominsky", "afominsky@gmail.com");
        Car alexCar = new Car("Porsche", 5);
        alexCar.setOwner(alex);
        alex.setCar(alexCar);
        userService.add(alex);

        User anon = new User("Anonymous", "FromRussia", "anonymous@email.ru");
        Car anonCar = new Car("Lada", -5);
        anonCar.setOwner(anon);
        anon.setCar(anonCar);
        userService.add(anon);

//        userService.add(new User("Mike", "Zhurikov", "zmo00@yandex.ru"),
//                new Car("Toyota", 1));
//        userService.add(new User("Alex", "Fominsky", "afominsky@gmail.com"),
//                new Car("Porsche", 5));
//        userService.add(new User("Anonymous", "FromRussia", "anonymous@email.ru"),
//                new Car("Lada", -5));

        List<User> users = userService.listUsers();
        System.out.println("__________");
        for (User user : users) {
            System.out.println(user.toString());
            System.out.println();
        }

        List<User> userWithCar = userService.userWithCar("Toyota", 1);
        System.out.println("__________");
        for (User user : userWithCar) {
            System.out.println(user.toString());
            System.out.println();
        }

        context.close();
    }
}
