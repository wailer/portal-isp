package com.tfc.uoc.edu.spring.web.rest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RestResponse {
    private RestError error;
 
    public RestError getError() {
        return error;
    }
 
    public void setError(RestError error) {
        this.error = error;
    }
}