package org.binarfood.service;

import java.util.List;

import org.binarfood.model.User;

public interface UserService {
    void create(User user);
    User getByUserPass(String username, String password);
    List<User> getList();
    boolean usernameExists(String username);
    boolean emailExists(String email);
    boolean passwordInvalid(String password);
}
