package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void save(User user);

    User getUser(Long id);

    void update(Long id, User user);

    void delete(Long id);
}
