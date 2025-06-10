package hiber.dao;

import hiber.model.User;
import java.util.List;


public interface UserDao {
   List<User> getAllUsers();
   void saveUser(User user);
   void updateUser(User user);
   void deleteUser(Long id);
   User getUserById(Long id);
}
