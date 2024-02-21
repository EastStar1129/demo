package com.cms.demo.verse.repository;

import com.cms.demo.verse.entity.Verse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerseRepository extends JpaRepository<Verse, Long> {
}
