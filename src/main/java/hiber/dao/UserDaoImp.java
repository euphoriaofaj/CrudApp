package hiber.dao;
import hiber.model.User;
import hiber.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
class UserDaoImpl implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<User> getAllUsers() {
      TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
      return query.getResultList();
   }

   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void saveUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

   @Override
   public void deleteUser(Long id) {
      User user = getUserById(id);
      if (user != null) {
         entityManager.remove(user);
      }
   }
}
