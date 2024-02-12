package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> query = session.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        var currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public User getUser(Long id) {
        var currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, id);
    }


    @Override
    public void update(Long id, User user) {
        var currentSession = sessionFactory.getCurrentSession();
        User userToBeUpdated = currentSession.get(User.class, id);
        if (userToBeUpdated != null) {
            userToBeUpdated.setFirstName(user.getFirstName());
            userToBeUpdated.setLastName(user.getLastName());
            userToBeUpdated.setEmail(user.getEmail());

            currentSession.update(userToBeUpdated);
        }
    }

    @Override
    public void delete(Long id) {
        var currentSession = sessionFactory.getCurrentSession();
        User userToBeDeleted = currentSession.get(User.class, id);
        currentSession.delete(userToBeDeleted);
    }
}
