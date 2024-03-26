package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;

public class ReviewDTO {

    private Long id;

    @NotBlank
    private String text;

    private Long movieId;

    private UserDTO user;

    @JsonIgnore
    private MovieDTO movie;

    public ReviewDTO(Long id, String text, UserDTO user, MovieDTO movie) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.movie = movie;
    }

    public ReviewDTO(Review review) {
        id = review.getId();
        text = review.getText();
        user = new UserDTO(review.getUser());
        movie = new MovieDTO(review.getMovie());
        movieId = review.getMovie().getId();
    }

    public ReviewDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
