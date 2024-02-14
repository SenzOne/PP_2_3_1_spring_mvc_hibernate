package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public void save(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
