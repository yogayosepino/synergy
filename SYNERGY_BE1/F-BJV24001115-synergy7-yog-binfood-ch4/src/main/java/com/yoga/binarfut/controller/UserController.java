package com.yoga.binarfut.controller;


import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.UserDto;
import com.yoga.binarfut.payload.UserUpdateEmailDto;
import com.yoga.binarfut.payload.UserUpdatePasswordDto;
import com.yoga.binarfut.payload.UserUpdateUsernameDto;
import com.yoga.binarfut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    //create
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> add(@RequestBody User user){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("user", userService.create(user));
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //read
    @GetMapping("read")
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
//        cara 1
//        data.put("cinemas", cinemaService.getCinemaList());

        List<User> userList = userService.getAll();
        List<UserDto> userDtoList = userList
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
        data.put("user", userDtoList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //update
    @PatchMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        User patchUser = userService.patchUser(id, userDto);
        return ResponseEntity.ok(patchUser);
    }

    @PutMapping("email/{id}")
    public ResponseEntity<User> updateEmailUser(@PathVariable UUID id, @RequestBody UserUpdateEmailDto userUpdateEmailDto) {
        User updateEmailUser = userService.updateEmailUser(id, userUpdateEmailDto);
        return ResponseEntity.ok(updateEmailUser);
    }

    @PutMapping("username/{email}")
    public ResponseEntity<User> updateEmailUser(@PathVariable String email, @RequestBody UserUpdateUsernameDto userUpdateUsernameDto) {
        User updateUsernameUser = userService.updateUsernameUser(email, userUpdateUsernameDto);
        return ResponseEntity.ok(updateUsernameUser);
    }
    @PutMapping("password/{username}")
    public ResponseEntity<User> updatePasswordUser(@PathVariable String username, @RequestBody UserUpdatePasswordDto userUpdatePasswordDto) {
        User updatePasswordUser = userService.updatePasswordUser(username, userUpdatePasswordDto);
        return ResponseEntity.ok(updatePasswordUser);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.softDeleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
