package com.cms.admin.user.service;

import com.cms.admin.admin.dto.UserRequestDTO;
import com.cms.admin.user.exception.UsernameAlreadyFoundException;
import com.cms.database.user.entity.User;
import com.cms.database.user.repository.UserRepository;
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
