package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(1L, "Michael","Johnston",  "MichaelJohnston@gmail.com"));
        userList.add(new User(1L, "Joseph","Murray",  "JosephMurray@gmail.com"));
        userList.add(new User(1L, "Gary","Sullivan",  "GarySullivan@gmail.com"));
    }

    public List<User> allUsers() {
        return userList;
    }
}
