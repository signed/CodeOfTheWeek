package com.github.signed.codeoftheweek.leakloader;

import java.io.File;
import java.net.URL;

public class StorageDirectory {
    public File getRoot() {
        URL resource = this.getClass().getClassLoader().getResource("leak/production.leak");
        return new File(resource.getFile()).getParentFile();
    }
}