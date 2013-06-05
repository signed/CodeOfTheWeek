package com.github.signed.codeoftheweek.leakloader;

import java.io.File;
import java.io.FilenameFilter;

public class LeakFileFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String fileName) {
        return fileName.endsWith(".leak");
    }
}
