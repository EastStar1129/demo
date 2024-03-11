package com.cms.demo.worship.repository;

import com.cms.demo.worship.dto.WorshipResponseDTO;
import com.cms.demo.worship.entity.Worship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorshipRepository extends JpaRepository<Worship, Long> {
    Optional<Worship> findFirstByOrderByIdxDesc();
}
