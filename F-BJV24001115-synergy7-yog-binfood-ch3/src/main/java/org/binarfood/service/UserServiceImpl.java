package org.binarfood.service;

import org.binarfood.Data;
import org.binarfood.exception.DataExistedException;
import org.binarfood.model.User;


import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements  UserService{
    @Override
    public void create(User user) {
        if (Data.USERS.stream().anyMatch(c -> c.getUsername().equals(user.getUsername()))) {
            throw new DataExistedException("Username telah terpakai: " + user.getUsername());
        } else if (Data.USERS.stream().anyMatch(c -> c.getEmail().equals(user.getEmail()))) {
            throw new DataExistedException("Email telah terpakai: " + user.getEmail());
        } else {
            user.setId(Data.USERS.size());
            Data.USERS.add(user);
        }
    }

    @Override
    public User getByUserPass(String username, String password) {
        Optional<User> user = Data.USERS.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();

        return user.orElse(null);

    }

    @Override
    public List<User> getList() {
        return Data.USERS;
    }

    @Override
    public boolean usernameExists(String username) {
        return Data.USERS.stream().anyMatch(u -> u.getUsername().equals(username));
    }

    @Override
    public boolean emailExists(String email) {
        return Data.USERS.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    @Override
    public boolean passwordInvalid(String password) {
        return password.length() < 12;
    }
}
