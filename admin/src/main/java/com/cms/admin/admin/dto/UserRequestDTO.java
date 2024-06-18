package com.cms.admin.admin.dto;

import com.cms.admin.user.data.UserRole;
import com.cms.database.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDTO {
    private String username;
    private String password;

    public static User of(UserRequestDTO userRequestDTO) {
        return User.builder()
                .username(userRequestDTO.getUsername())
                .password(userRequestDTO.getPassword())
                .role(UserRole.USER.name())
                .isDel(false)
                .build();
    }
}
