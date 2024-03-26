package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public List<com.devsuperior.movieflix.dto.GenreDTO> findAll() {

        List<Genre> genres = repository.findAll();
        return genres.stream().map(com.devsuperior.movieflix.dto.GenreDTO::new)
                .collect(Collectors.toList());
    }
}
