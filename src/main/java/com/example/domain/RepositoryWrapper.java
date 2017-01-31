package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by dg on 30/01/2017.
 *
 */
@Data
@AllArgsConstructor
public class RepositoryWrapper {
    private List<Repository> repositories;
    private List<Link> links;
}
