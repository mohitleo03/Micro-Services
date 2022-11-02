package org.ncu.hirewheels.services;

import org.ncu.hirewheels.dto.Request.UserRequestDto;
import org.ncu.hirewheels.dto.Response.UserResponseDto;

public interface UserService {
    public UserResponseDto createUser(UserRequestDto userDto) throws Exception;
    public UserResponseDto getUser(String email, String password) throws Exception;
}
