package com.yoga.binarfut.service;

import com.yoga.binarfut.exception.EmailExistedException;
import com.yoga.binarfut.exception.NotFoundEmailException;
import com.yoga.binarfut.exception.NotFoundIdException;
import com.yoga.binarfut.exception.NotFoundUsernameException;
import com.yoga.binarfut.model.Merchant;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.UserDto;
import com.yoga.binarfut.payload.UserUpdateEmailDto;
import com.yoga.binarfut.payload.UserUpdatePasswordDto;
import com.yoga.binarfut.payload.UserUpdateUsernameDto;
import com.yoga.binarfut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void softDeleteUser(UUID id) {
        Optional<User> user = userRepository.findById(id);

        user.ifPresent(u -> {
            u.setDeleted(true);
            userRepository.save(u);
        });
    }

    @Override
    public User updateEmailUser(UUID id, UserUpdateEmailDto userUpdateEmailDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundIdException("User not found with id " + id);
        }
        User user = optionalUser.get();

        if (userUpdateEmailDto.getEmail() != null) {
            user.setEmail(userUpdateEmailDto.getEmail());
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUsernameUser(String email, UserUpdateUsernameDto userUpdateUsernameDto) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new NotFoundEmailException("User not found with email " + email);
        }
        User user = optionalUser.get();

        if (userUpdateUsernameDto.getUsername() != null) {
            user.setUsername(userUpdateUsernameDto.getUsername());
        }

        return userRepository.save(user);
    }

    @Override
    public User updatePasswordUser(String username, UserUpdatePasswordDto userUpdatePasswordDto) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new NotFoundUsernameException("User not found with username " + username);
        }
        User user = optionalUser.get();

        if (userUpdatePasswordDto.getPassword() != null) {
            user.setPassword(userUpdatePasswordDto.getPassword());
        }

        return userRepository.save(user);
    }

    @Override
    public User patchUser(UUID id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new NotFoundIdException("User not found with id " + id);
        }
        User user = optionalUser.get();

        if (userDto.getUsername() != null) {
            user.setUsername(userDto.getUsername());
        }
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }
        if (userDto.getRole() != null ){
            user.setRole(userDto.getRole());
        }
        return userRepository.save(user);

    }

    @Override
    public User getById(UUID id) {
        Optional<User>userOptional =userRepository.findById(id);

        if (userOptional.isEmpty()){
            throw new RuntimeException("nothing");
        } else{
            return userOptional.get();
        }
    }
}
