package com.example;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by dg on 2017-02-09.
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "github.basicauth")
public class GitHubSettings {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String baseUrl;
}

