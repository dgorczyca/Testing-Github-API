package com.example.domain;

import lombok.Data;

/**
 * Created by dg on 30/01/2017.
 */
@Data
public class Link {
    private String rel;
    private String url;

    public Link(String rel, String url) {
        this.rel = rel;
        this.url = url;
    }
}
