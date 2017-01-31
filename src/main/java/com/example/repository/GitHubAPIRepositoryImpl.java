package com.example.repository;

import com.example.domain.Language;
import com.example.domain.Link;
import com.example.domain.Repository;
import com.example.domain.RepositoryWrapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * Created by dg on 30/01/2017.
 */
@Component
public class GitHubAPIRepositoryImpl implements GitHubAPIRepository {
    private final String repoOfInterest = "nasa";
    private final String GIT_HUB_API_BASE_URL = "https://api.github.com/";
    private final String GIT_HUB_API_REPO_URL = "/repos/{repoOfInterest}/{repoName}";
    private final String GIT_HUB_API_LANGUAGES_URL = GIT_HUB_API_REPO_URL + "/languages";
    private final String GIT_HUB_API_USER_REPOSITORIES_URL = GIT_HUB_API_BASE_URL + "/users/{repoOfInterest}/repos";


    private final RestTemplate restTemplate;

    public GitHubAPIRepositoryImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .rootUri(GIT_HUB_API_BASE_URL)
                .setConnectTimeout(15000)
                .build();
    }

    private List<String> getRemainingRepositoryLinks(ResponseEntity<Repository[]> responseEntity) {
        List<String> links = responseEntity.getHeaders().get("link");
        if (links == null || links.isEmpty()) {
            throw new RuntimeException("cannot find link header");
        }
        return links;
    }

    private List<Link> findLinks(List<String> header) {
        List<Link> links = new ArrayList<>();
        for (String linksHeader: header) {
            List<String> linksSplit = Arrays.asList(linksHeader.split(","));
            for (String linkHeader: linksSplit) {
                int relStart = linkHeader.indexOf("rel=")+5;
                int relEnd = linkHeader.substring(relStart).indexOf("\"");
                String rel = linkHeader.substring(relStart, relStart+relEnd);

                String href = linkHeader.substring(linkHeader.indexOf("<") + 1, linkHeader.indexOf(">"));
                links.add(new Link(rel, href));
            }
        }
        return links;
    }

    public RepositoryWrapper getRepositories() {
        ResponseEntity<Repository[]> responseEntity = restTemplate.getForEntity(GIT_HUB_API_USER_REPOSITORIES_URL, Repository[].class, repoOfInterest);
        List<Link> links = findLinks(getRemainingRepositoryLinks(responseEntity));

        return new RepositoryWrapper(Arrays.asList(responseEntity.getBody()), null);
    }

    public RepositoryWrapper getNextPage(String nextPageLink) {
        ResponseEntity<Repository[]> responseEntity = restTemplate.getForEntity(nextPageLink, Repository[].class);
        List<Link> links = findLinks(getRemainingRepositoryLinks(responseEntity));

        return new RepositoryWrapper(Arrays.asList(responseEntity.getBody()), null);
    }

    public List<Language> getRepoLanguages(String repoName) {

        ResponseEntity<Map<String, Integer>> responseEntity = restTemplate.exchange(GIT_HUB_API_LANGUAGES_URL, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String,Integer>>() {}, repoOfInterest, repoName);
        Map<String, Integer> mapLanguages = responseEntity.getBody();
        List<Language> languages = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapLanguages.entrySet()) {
            languages.add(new Language(entry.getKey(), entry.getValue()));
        }
        return languages;
    }
}
