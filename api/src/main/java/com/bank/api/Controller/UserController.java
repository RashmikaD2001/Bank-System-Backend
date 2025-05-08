package com.bank.api.Controller;

import com.bank.api.Model.UserModel;
import com.bank.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{nic}")
    public Optional<UserModel> getUserByNic(@PathVariable String nic) {
        return userService.getUserById(nic);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserModel user) {
        userService.saveUser(user);
    }

    @PutMapping("/{nic}")
    public void updateUser(@PathVariable String nic, @RequestBody UserModel user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
