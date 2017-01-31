package com.example.service;

import com.example.domain.Repository;
import com.example.domain.RepositoryWrapper;
import com.example.repository.GitHubAPIRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Created by dg on 30/01/2017.
 */
@RequiredArgsConstructor
public class RepositoryService {
    @NonNull
    private GitHubAPIRepository gitHubAPIRepository;

}
