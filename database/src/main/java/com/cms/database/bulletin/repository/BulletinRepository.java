package com.cms.database.bulletin.repository;

import com.cms.database.bulletin.entity.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
    Optional<Bulletin> findFirstByOrderByIdxDesc();
}
