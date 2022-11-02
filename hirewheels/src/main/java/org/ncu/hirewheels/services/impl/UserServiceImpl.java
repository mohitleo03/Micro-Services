package org.ncu.hirewheels.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.ncu.hirewheels.dto.Request.UserRequestDto;
import org.ncu.hirewheels.dto.Response.UserResponseDto;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.repository.RoleRepository;
import org.ncu.hirewheels.repository.UserRepository;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    @Async
    public UserResponseDto createUser(UserRequestDto userDto) throws Exception {
        try {
            Optional<Role> role = roleRepository.getRoleById(userDto.getRole_id());
            if (role.isPresent()) {
                Role curr_role = role.get();
                Role role_to_save = new Role(curr_role.getRole_id(), curr_role.getRole_name());
                Optional<User> userWithEmail = userRepository.getUserByEmail(userDto.getEmail());
                Optional<User> userWithPhoneNumber = userRepository.getUserByMobileNo(userDto.getMobile_no());
                if (!userWithEmail.isPresent() && !userWithPhoneNumber.isPresent()) {
                    User curr_user = new User(userDto.getFirst_name(), userDto.getLast_name(), userDto.getPassword(),
                            userDto.getEmail(),
                            userDto.getMobile_no(), role_to_save);
                    User userToSave = userRepository.save(curr_user);
                    UserResponseDto userResponseDto = new UserResponseDto(userToSave.getFirst_name(),
                            userToSave.getLast_name(), userToSave.getPassword(), userToSave.getEmail(),
                            userToSave.getMobile_no(), userToSave.getRole());
                    return userResponseDto;
                } else {
                    throw new Exception("User Already Present");
                }
            } else {
                throw new Error("Role not Present");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    @Transactional
    public UserResponseDto getUser(String email, String password) throws Exception {
        try {
            Optional<User> user = userRepository.getUserByEmail(email);
            if (user.isPresent()) {
                User user2 = user.get();
                if (user2.getPassword().equals(password)) {
                    User cUser =  user.get();
                    Role cRole = cUser.getRole();
                    Role role_to_save = new Role(cRole.getRole_id(), cRole.getRole_name());
                    UserResponseDto userResponseDto = new UserResponseDto(cUser.getFirst_name(),
                            cUser.getLast_name(), cUser.getPassword(), cUser.getEmail(),
                            cUser.getMobile_no(), role_to_save);
                    return userResponseDto;
                } else {
                    throw new Exception("Email/Password is incorrect");
                }
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
