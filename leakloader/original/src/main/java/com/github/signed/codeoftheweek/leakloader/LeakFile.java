package com.github.signed.codeoftheweek.leakloader;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeakFile {

    public LeakFile() {
    }

    public ImmutableMap<Secret, Leak> getLeak() {
        return ImmutableMap.copyOf(readLeaks());
    }

    private Map<Secret, Leak> readLeaks() {
        Map<Secret, Leak> leaks = new HashMap<Secret, Leak>();
        for (File leakFile: getConfigurationFiles(new StorageDirectory().getRoot())) {
            final Leak leak = new LeakJsonConverter().getLeakForJSon(readTxtFile(leakFile));
            leaks.put(leak.getSecret(), leak);
        }
        return leaks;
    }

    String readTxtFile(File aFile) {
        FileInputStream inputStream = null;
        String content;
        try {
            try {
                inputStream = new FileInputStream(aFile);
                content = IOUtils.toString(inputStream);
            } finally {
                if (inputStream != null)
                    inputStream.close();
            }
        } catch (Exception e) {
            System.out.println(aFile.getAbsolutePath());
            throw new RuntimeException(e);
        }
        return content;
    }

    List<File> getConfigurationFiles(File directory) {
        final File[] files = directory.listFiles(new LeakFileFilter());
        if (files == null || files.length == 0) {
            return new ArrayList<File>();
        }
        return Arrays.asList(files);
    }

}