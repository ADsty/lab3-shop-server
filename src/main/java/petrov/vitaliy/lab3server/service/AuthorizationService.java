package petrov.vitaliy.lab3server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petrov.vitaliy.lab3server.dao.UserDAO;
import petrov.vitaliy.lab3server.model.User;

import java.util.List;

@Service
public class AuthorizationService {

    private final UserDAO userDAO;

    @Autowired
    public AuthorizationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean addUser(User user) {
        List<User> userList = userDAO.getUserList();
        User userCandidate = findUserByName(user.getUsername());
        if (userCandidate == null) {
            userList.add(user);
        }
        return userCandidate == null;
    }

    public boolean authorizeUser(User user) {
        User userCandidate = findUserByName(user.getUsername());
        return userCandidate != null;
    }

    public boolean deleteUser(User user) {
        List<User> userList = userDAO.getUserList();
        User userCandidate = findUserByName(user.getUsername());
        if (userCandidate == null) return false;
        return userList.remove(userCandidate);
    }

    private User findUserByName(String username) {
        List<User> userList = userDAO.getUserList();
        return userList.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }
}
