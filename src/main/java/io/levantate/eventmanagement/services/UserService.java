package io.levantate.eventmanagement.services;

import io.levantate.eventmanagement.models.User;
import io.levantate.eventmanagement.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username); 
    }



    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Login successful
        }
        return user; // Login failed
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public boolean userExistsByUserId(Long userId) {
        return userRepository.findById(userId).isPresent();
    }
}
