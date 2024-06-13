package com.cms.demo.user.repository;

import com.cms.demo.user.entity.User;
import com.cms.demo.worship.entity.Worship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
