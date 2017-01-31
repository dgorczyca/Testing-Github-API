package com.example.repository;

import com.example.domain.Language;
import com.example.domain.Repository;
import com.example.domain.RepositoryWrapper;

import java.util.List;

/**
 * Created by dg on 30/01/2017.
 */
public interface GitHubAPIRepository {
    List<Language> getRepoLanguages(String repoName);
    RepositoryWrapper getRepositories();
    RepositoryWrapper getNextPage(String nextPageLink);
}
