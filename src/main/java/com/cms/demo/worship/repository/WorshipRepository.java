package com.cms.demo.worship.repository;

import com.cms.demo.worship.entity.Worship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorshipRepository extends JpaRepository<Worship, Long> {
}
