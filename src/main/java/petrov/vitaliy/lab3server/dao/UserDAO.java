package petrov.vitaliy.lab3server.dao;

import org.springframework.stereotype.Component;
import petrov.vitaliy.lab3server.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    List<User> userList;

    {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }
}
