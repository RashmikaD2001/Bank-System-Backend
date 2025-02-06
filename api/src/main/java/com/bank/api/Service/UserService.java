package com.bank.api.Service;

import com.bank.api.Model.UserModel;
import com.bank.api.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(String id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(UserModel user) {
        userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public void updateUser(UserModel user) {
        if (getUserById(user.getNic()) != null){
            userRepository.save(user);
        }else{
            throw new RuntimeException("No user with for given nic " + user.getNic());
        }
    }
}
