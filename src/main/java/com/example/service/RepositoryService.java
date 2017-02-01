package com.example.service;

import com.example.domain.Repository;
import com.example.domain.RepositoryWrapper;
import com.example.repository.GitHubAPIRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dg on 30/01/2017.
 */
@RequiredArgsConstructor
@Component
public class RepositoryService {
    @NonNull
    private GitHubAPIRepository gitHubAPIRepository;

    public List<Repository> getAllReposiotories() {
        RepositoryWrapper repositoryWrapper = gitHubAPIRepository.getRepositories();
        List<Repository> repositories = repositoryWrapper.getRepositories();
        while (repositoryWrapper.hasNextPageLink()) {
            repositoryWrapper = gitHubAPIRepository.getNextPage(repositoryWrapper.getNextPageLinkUrl());
            repositories.addAll(repositoryWrapper.getRepositories());
        }
        return repositories;
    }
}
