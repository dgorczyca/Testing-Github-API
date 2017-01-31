package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Created by dg on 30/01/2017.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    private String name;
    @JsonIgnore
    private List<Language> languageList;
}
