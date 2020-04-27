package com.github.ahsanmaster.todolist.service;

import com.github.ahsanmaster.todolist.domain.User;
import com.github.ahsanmaster.todolist.dto.UserDto;
import com.github.ahsanmaster.todolist.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userRepository.save(user);
    }
}
