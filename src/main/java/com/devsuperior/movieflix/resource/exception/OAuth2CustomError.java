package com.devsuperior.movieflix.resource.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OAuth2CustomError implements Serializable {

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;

    public OAuth2CustomError() {

    }

    public OAuth2CustomError(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
