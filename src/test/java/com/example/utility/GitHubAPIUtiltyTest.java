package com.example.utility;

import com.example.domain.Link;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by dg on 03/02/2017.
 */
public class GitHubAPIUtiltyTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseLinkParseNextLinkShouldReturnLinkWithRelEqualNextTest() {
        Link link = GitHubAPIUtility.parseLink("<https://api.github.com/user/848102/repos?page=2>; rel=\"next\"");
        assertThat(link).isNotNull();
        assertThat(link.getRel()).isEqualTo("next");
        assertThat(link.getUrl()).isEqualTo("https://api.github.com/user/848102/repos?page=2");
    }

    @Test
    public void parseLinkWhenLinkIsNullShouldThrowIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        GitHubAPIUtility.parseLink(null);
    }

    @Test
    public void parseLinkWhenLinkDoesNotContainRelStringShouldThrowIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        GitHubAPIUtility.parseLink("<https://api.github.com/user/848102/repos?page=2>;");
    }

    @Test
    public void parseLinkWhenLinkDoesNotContainURLShouldThrowIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        GitHubAPIUtility.parseLink("; rel=\"next\"");
    }

}
