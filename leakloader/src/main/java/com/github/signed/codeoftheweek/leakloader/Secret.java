package com.github.signed.codeoftheweek.leakloader;

public class Secret {

    public static Secret Secret(String secretString) {
        return new Secret(secretString);
    }

    private final String secretString;

    public Secret(String secretString) {
        this.secretString = secretString;
    }

    @Override
    public String toString() {
        return secretString;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Secret)) {
            return false;
        }
        Secret that = (Secret) obj;
        return this.secretString.equals(that.secretString);
    }

    @Override
    public int hashCode() {
        return secretString.hashCode();
    }
}