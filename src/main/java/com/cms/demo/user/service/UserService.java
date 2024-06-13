package com.cms.demo.user.service;

import com.cms.demo.admin.dto.UserRequestDTO;
import com.cms.demo.user.entity.User;
import com.cms.demo.user.exception.UsernameAlreadyFoundException;
import com.cms.demo.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserRequestDTO userRequestDTO) {
        if (userRepository.findByUsername(userRequestDTO.getUsername()).isPresent()) {
            throw new UsernameAlreadyFoundException();
        }

        User user = UserRequestDTO.of(userRequestDTO);
        userRepository.save(user);
    }
}
