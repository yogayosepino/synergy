package com.yoga.binarfut.payload;

import lombok.Data;
import com.yoga.binarfut.model.User.Role;

@Data
public class UserDto {
    private String username;
    private String email;
    private String password;

    private Role role;
}
