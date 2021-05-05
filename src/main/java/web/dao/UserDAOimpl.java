package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDAOimpl implements UserDAO{

    @PersistenceContext(unitName = "em")
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("delete from User u where u.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void edit(User user) {
//        User userFromDB = findById(user.getId());
//        userFromDB.setFirstName(user.getFirstName());
//        userFromDB.setLastName(user.getLastName());
        entityManager.merge(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
