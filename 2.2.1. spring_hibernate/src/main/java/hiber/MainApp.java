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

        userService.add(new User("Mike", "Zhurikov", "zmo00@yandex.ru",
                new Car("Toyota", 1)));
        userService.add(new User("Alex", "Fominsky", "afominsky@gmail.com",
                new Car("Porsche", 5)));
        userService.add(new User("Name", "Lastname", "lastname.n@email.web",
                new Car("Lada", -3)));

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
