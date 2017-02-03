package com.example.utility;

import com.example.domain.Link;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dg on 03/02/2017.
 */
public class GitHubAPIUtility {
    public static Link parseLink(String link){
        Assert.hasText(link);

        int indexOfEndURL = link.indexOf(">");
        int indexOfStartURL = link.indexOf("<");
        int indexOfRel = link.indexOf("rel=");
        if (indexOfRel == -1 || indexOfStartURL == -1 || indexOfEndURL == -1)
            throw new IllegalArgumentException("Link not parsable " + link);

        int relStart = indexOfRel +5;
        int relEnd = link.substring(relStart).indexOf("\"");
        String rel = link.substring(relStart, relStart+relEnd);
        String url = link.substring( indexOfStartURL + 1, indexOfEndURL);
        return new Link(rel, url);
    }
}
