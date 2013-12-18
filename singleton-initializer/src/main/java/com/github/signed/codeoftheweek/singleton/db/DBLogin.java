package com.github.signed.codeoftheweek.singleton.db;

public class DBLogin {
    private final String url;
    private final String user;
    private final String password;
    private final String schema;

    public DBLogin(ServerInfo serverInfo)  {
        this(serverInfo.getDBUrl(), serverInfo.getRemoteUser(), serverInfo.getPassword(), serverInfo.getDBSchemaUser());
    }

    DBLogin(String url, String user, String password, String schema) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.schema = schema;
    }

    public final String getSchema() {
        return schema;
    }

    public String getUser() {
        return user;
    }

    public final String getPassword() {
        return password;
    }

    public final String getUrl() {
        return url;
    }

}
