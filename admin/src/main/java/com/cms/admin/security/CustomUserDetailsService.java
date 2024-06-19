package com.cms.admin.security;

import com.cms.database.user.entity.User;
import com.cms.database.user.repository.UserRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepositoryImpl userRepositoryImpl;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepositoryImpl.findByUsername(username);
        if (user.isPresent()) {
            return new CustomUserDetails(user.get());
        }

        throw new UsernameNotFoundException(username + "을 찾을 수 없습니다");
    }
}
