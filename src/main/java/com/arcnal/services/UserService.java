package com.arcnal.services;

import com.arcnal.entity.User;
import com.arcnal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
