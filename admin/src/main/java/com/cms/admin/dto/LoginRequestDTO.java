package com.cms.admin.login.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginRequestDTO {
    private String username;
    private String password;
}
