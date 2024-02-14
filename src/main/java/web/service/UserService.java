package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void save(User user);

    void update(User user);

    void delete(Long id);

    User getUser(Long id);
}
