package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public MovieDTO findById(Long id) {
        Optional<Movie> movie = repository.findById(id);
        if (movie.isPresent()) {
            return new MovieDTO(movie.get(), movie.get().getReviews());
        }
        throw new ResourceNotFoundException("Filme não encontrado.");
    }

    public Page<MovieCardDTO> findAllPaged(Pageable pageable, Long genreId) {
        Genre genre = genreId != 0 ? genreRepository.findById(genreId).get() : null;
        Page<Movie> page = repository.find(pageable, genre);
        return page.map(MovieCardDTO::new);
    }

    public List<ReviewDTO> getReviewByMovie(Long movieId) {
        Optional<Movie> movie = repository.findById(movieId);
        List<Review> movies = reviewRepository.find(movie.get());
        return movies.stream().map(ReviewDTO::new).collect(Collectors.toList());

    }
}
