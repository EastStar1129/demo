package com.cms.database.worship.repository;

import com.cms.database.worship.entity.Worship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorshipRepositoryImpl extends JpaRepository<Worship, Long> {
    Optional<Worship> findFirstByOrderByIdxDesc();
}
