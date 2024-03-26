package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.Role;
import com.devsuperior.movieflix.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private List<Role> roles = new ArrayList<>();

    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    public UserDTO(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
