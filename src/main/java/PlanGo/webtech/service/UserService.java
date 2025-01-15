package PlanGo.webtech.service;

import PlanGo.webtech.model.User;
import PlanGo.webtech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            return null;
        }
        return userRepository.save(user);
    }

    public boolean removeUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
