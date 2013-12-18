
package com.github.signed.codeoftheweek.singleton.db;

public abstract class BasisLoginManager {

    private final String connectKey;
    private final String applUser;
    private final String applUserPassword;
    private final String schemaUser;
    private final String persistenceManagerClassName;
    private String dbUrl;

    protected BasisLoginManager(String connectKey, String applUser, String applUserPassword, String schemaUser, String persistenceManagerClassName) {
        this.connectKey = connectKey;
        this.applUser = applUser;
        this.applUserPassword = applUserPassword;
        this.schemaUser = schemaUser;
        this.persistenceManagerClassName = persistenceManagerClassName;
    }

    public String getPersistenceManagerClassName() {
        return persistenceManagerClassName;
    }

    public String getDbUrl() {
        return dbUrl != null ? dbUrl : System.getProperty(connectKey);
    }

    public DBLogin getLoginInfo(String url) {
        dbUrl = url;
        return new DBLogin(url, applUser, applUserPassword, schemaUser);
    }

    @Override
    public String toString() {
        return "URL: " + dbUrl + " / DB-User: " + applUser;
    }
}
