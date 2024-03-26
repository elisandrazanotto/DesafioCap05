package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    public ReviewDTO insert(ReviewDTO dto) {

        UserDTO userDTO = userService.currentUserProfile();
        dto.setUser(userDTO);

        MovieDTO movieDTO = movieService.findById(dto.getMovieId());
        dto.setMovie(movieDTO);

        Review review = new Review();
        review.setText(dto.getText());
        review.setMovie(new Movie(movieDTO));
        review.setUser(new User(userDTO));

        return new ReviewDTO(repository.save(review));
    }
}
