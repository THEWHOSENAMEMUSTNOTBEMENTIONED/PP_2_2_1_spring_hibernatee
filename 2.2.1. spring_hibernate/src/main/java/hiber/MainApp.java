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

      Car car1 = new Car("Toyota", 1234);
      Car car2 = new Car("Honda", 5678);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();


      Car userCar = user.getCar();
      if (userCar != null) {
         System.out.println("Car model = " + userCar.getModel());
         System.out.println("Car series = " + userCar.getSeries());
      } else {
         System.out.println("No car assigned to this user.");
      }
      System.out.println();
   }
      List<User> userss = userService.getUserByCarModelAndSeries("Toyota", 1234);
      for (User user : userss) {
         System.out.println("Found user: " + user.getFirstName() + " " + user.getLastName());
      }

      context.close();
   }
}
