package com.cms.demo.verse.repository;

import com.cms.demo.verse.entity.Worship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorshipRepository extends JpaRepository<Worship, Long> {
}
