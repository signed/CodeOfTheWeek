package com.github.signed.codeoftheweek.leakloader;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileConfiguration_Test {

    public static final String FILENAME_DUMMY_CONFIGURATION = "/leak/dummy.leak";

    @Test
    public void getLeakReturnsAMap() throws Exception {
        assertThat(new LeakFile().getLeak(), isA(Map.class));
    }

    @Test
    public void readATxtFile() throws Exception {
        URL resource = this.getClass().getResource(FILENAME_DUMMY_CONFIGURATION);
        File aFile= new File(resource.getFile());
        assertThat(new LeakFile().readTxtFile(aFile).length(), Matchers.greaterThan(0));
    }

    @Test
    public void readDirectoryOfConfigurations() throws Exception {
        URL resource = this.getClass().getResource(FILENAME_DUMMY_CONFIGURATION);
        File directory = new File(resource.getFile()).getParentFile();
        System.out.println(directory.getAbsolutePath()); System.out.flush();
        assertThat(new LeakFile().getConfigurationFiles(directory).size(), is(2));
    }
}