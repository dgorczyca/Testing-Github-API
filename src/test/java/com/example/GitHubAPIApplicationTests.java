package com.example;

import com.example.domain.Language;
import com.example.domain.Repository;
import com.example.domain.RepositoryWrapper;
import com.example.repository.GitHubAPIRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GitHubAPIApplicationTests {

    @Autowired
    private GitHubAPIRepository gitHubAPIRepository;

	@Test
	public void checkLanguagesDomainJSONMapping() {
        List<Language> repoLanguages = gitHubAPIRepository.getRepoLanguages("CCDD");
        System.out.println(repoLanguages);
	}

	@Test
	public void checkRepositoryDomainJSONMapping() {
        RepositoryWrapper repositoryWrapper = gitHubAPIRepository.getRepositories();
        System.out.println(repositoryWrapper.getRepositories());
	}



}
