package com.cms.demo.main.service;

import com.cms.demo.verse.entity.Verse;
import com.cms.demo.verse.repository.VerseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerseService {
    private final VerseRepository verseRepository;

    public VerseService(VerseRepository verseRepository) {
        this.verseRepository = verseRepository;
    }

    public List<Verse> verses() {
        return verseRepository.findAll();
    }
}