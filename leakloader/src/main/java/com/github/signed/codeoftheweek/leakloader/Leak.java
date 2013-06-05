package com.github.signed.codeoftheweek.leakloader;


public class Leak {
    private final String identifier;
    private final Secret secret;
    private final String source;

    public Leak(String identifier, Secret secret, String source) {
        this.identifier = identifier;
        this.secret = secret;
        this.source = source;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Secret getSecret() {
        return secret;
    }

    public String getSource() {
        return source;
    }
}