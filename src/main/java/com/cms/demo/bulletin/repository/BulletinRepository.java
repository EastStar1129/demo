package com.cms.demo.bulletin.repository;

import com.cms.demo.bulletin.entity.Bulletin;
import com.cms.demo.worship.entity.Worship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
    Optional<Bulletin> findFirstByOrderByIdxDesc();
}
