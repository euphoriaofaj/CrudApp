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
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Toyota", 100);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(car1);

      Car car2 = new Car("Mercedes", 200);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(car2);

      Car car3 = new Car("BMW", 300);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(car3);

      Car car4 = new Car("Hyundai", 400);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         }
         System.out.println();
      }

      User userWithBMW = userService.getUserByCar("BMW", 520);
      System.out.println("User with BMW 520:");
      System.out.println("Id = " + userWithBMW.getId());
      System.out.println("Name = " + userWithBMW.getFirstName() + " " + userWithBMW.getLastName());
      System.out.println("Email = " + userWithBMW.getEmail());

      context.close();
   }
}