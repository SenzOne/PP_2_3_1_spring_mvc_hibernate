package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static Long USER_COUNT = 0L;
    private List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(++USER_COUNT, "Michael", "Johnston", "MichaelJohnston@gmail.com"));
        userList.add(new User(++USER_COUNT, "Joseph", "Murray", "JosephMurray@gmail.com"));
        userList.add(new User(++USER_COUNT, "Gary", "Sullivan", "GarySullivan@gmail.com"));
    }

    public List<User> allUsers() {
        return userList;
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        userList.add(user);
    }
}
