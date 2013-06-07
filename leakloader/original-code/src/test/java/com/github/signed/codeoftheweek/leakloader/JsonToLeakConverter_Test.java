package com.github.signed.codeoftheweek.leakloader;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

public class JsonToLeakConverter_Test {
    final String jsonLeak = "{\"identifier\":\"Me\",\"secret\":\"forMe\",\"source\":\"none\"}";
    LeakJsonConverter jsonToLeakConverter;

    @Before
    public void setUp() throws Exception {
        jsonToLeakConverter = new LeakJsonConverter();
    }

    @Test
    public void parseAConfigurationForALeak() throws Exception {
        MatcherAssert.assertThat(jsonToLeakConverter.getLeakForJSon(jsonLeak).getIdentifier(), CoreMatchers.is("Me"));
    }

    @Test
    public void parseAConfigurationForALeakAndCheckSecret() throws Exception {
        MatcherAssert.assertThat(jsonToLeakConverter.getLeakForJSon(jsonLeak).getSecret(), CoreMatchers.equalTo(new Secret("forMe")));
    }

    @Test
    public void parseAConfigurationForALeakAndCheckSource() throws Exception {
        MatcherAssert.assertThat(jsonToLeakConverter.getLeakForJSon(jsonLeak).getSource(), CoreMatchers.is("none"));
    }

    @Test
    public void compareParsedAndCreatedJsonCodeForALeak() throws Exception {
        Leak leak = jsonToLeakConverter.getLeakForJSon(jsonLeak);
        MatcherAssert.assertThat(jsonToLeakConverter.getJsonForLeak(leak), CoreMatchers.equalTo(jsonLeak));
    }
}