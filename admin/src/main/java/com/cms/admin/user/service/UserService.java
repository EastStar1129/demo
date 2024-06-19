package com.cms.admin.user.service;

import com.cms.admin.admin.dto.UserRequestDTO;
import com.cms.admin.user.exception.UsernameAlreadyFoundException;
import com.cms.database.user.entity.User;
import com.cms.database.user.repository.UserRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepositoryImpl userRepositoryImpl;

    public void save(UserRequestDTO userRequestDTO) {
        if (userRepositoryImpl.findByUsername(userRequestDTO.getUsername()).isPresent()) {
            throw new UsernameAlreadyFoundException();
        }

        User user = UserRequestDTO.of(userRequestDTO);
        userRepositoryImpl.save(user);
    }
}
