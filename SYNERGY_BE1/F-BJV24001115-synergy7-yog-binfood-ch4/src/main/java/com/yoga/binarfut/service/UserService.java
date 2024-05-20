package com.yoga.binarfut.service;

import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.UserDto;
import com.yoga.binarfut.payload.UserUpdateEmailDto;
import com.yoga.binarfut.payload.UserUpdatePasswordDto;
import com.yoga.binarfut.payload.UserUpdateUsernameDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User create(User user);

    List<User> getAll();

    void softDeleteUser(UUID id);

    User updateEmailUser(UUID Id, UserUpdateEmailDto userUpdateEmailDto);

    User updateUsernameUser(String email, UserUpdateUsernameDto userUpdateUsernameDto);

    User updatePasswordUser(String password, UserUpdatePasswordDto userUpdatePasswordDto);

    User patchUser(UUID id, UserDto userDto);

    User getById(UUID id);
}
