package com.cms.admin.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class SecurityConfigTest {

    @Test
    public void passwrodEncryptTest() {
        var password = new BCryptPasswordEncoder().encode("admin");
        assertNotNull(password);
    }

}