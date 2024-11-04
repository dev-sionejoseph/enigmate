package com.devsione.enigmate.service;

import com.devsione.enigmate.model.User;
import com.devsione.enigmate.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
