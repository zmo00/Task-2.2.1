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

        userService.add(new User("Vova", "Zhurikov", "zvo93@yandex.ru",
                new Car("Kia", 1)));
        userService.add(new User("Mike", "Zhurikov", "zmo00@yandex.ru",
                new Car("Toyota", 10)));
        userService.add(new User("Grisha", "Zhurikov", "zgo04@yandex.ru",
                new Car("Nisan", 5)));
        userService.add(new User("Fedja", "Zhurikov", "zfo07@yandex.ru",
                new Car("BMV", 6)));

        List<User> users = userService.listUsers();
        System.out.println("__________");
        for (User user : users) {
            System.out.println(user.toString());
            System.out.println();
        }

        context.close();
    }
}
