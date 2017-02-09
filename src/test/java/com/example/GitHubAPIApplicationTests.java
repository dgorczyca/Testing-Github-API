package com.example;

import com.example.domain.Language;
import com.example.domain.Repository;
import com.example.domain.RepositoryWrapper;
import com.example.repository.GitHubAPIRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GitHubAPIApplicationTests {

    @Autowired
    private MockRestServiceServer server;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private GitHubAPIRepository gitHubAPIRepository;

	@Test
	public void checkLanguagesDomainJSONMapping() {
        this.server.expect(MockRestRequestMatchers.requestTo("path...."));
        List<Language> repoLanguages = gitHubAPIRepository.getRepoLanguages("CCDD");
        System.out.println("repoLanguages = " + repoLanguages);
//        hasJsonPath()
	}

	@Test
	public void checkRepositoryDomainMapping() {
        RepositoryWrapper repositoryWrapper = gitHubAPIRepository.getRepositories();
        System.out.println(repositoryWrapper.getRepositories());
	}
}
