package com.achraf.security.service.impl;

import com.achraf.security.dto.UserDTO;
import com.achraf.security.mapper.UserMapper;
import com.achraf.security.model.User;
import com.achraf.security.repository.UserRepository;
import com.achraf.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        // password should be set by register flow; here it's a placeholder
        user.setPassword("{noop}password");
        userRepository.save(user);
        return userMapper.toDTO(user);
    }
}
