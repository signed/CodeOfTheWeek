
package com.github.signed.codeoftheweek.singleton.db;

public class PersistenceManagerFactory {

    protected final BasisLoginManager loginManager;

    public PersistenceManagerFactory(BasisLoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public GenPersistenceManager createPersistenceManager(boolean temporary) throws DataSourceException, ClassNotFoundException {
        return createPersistenceManager(1, loginManager.getDbUrl(), temporary);
    }

    public GenPersistenceManager createPersistenceManager(String dbUrl, boolean temporary) throws DataSourceException, ClassNotFoundException {
        return createPersistenceManager(1, dbUrl, temporary);
    }

    public GenPersistenceManager createPersistenceManager(int poolSize, boolean temporary) throws DataSourceException, ClassNotFoundException {
        return createPersistenceManager(poolSize, loginManager.getDbUrl(), temporary);
    }

    public GenPersistenceManager createPersistenceManager(int poolSize, String dbUrl, boolean temporary) throws DataSourceException, ClassNotFoundException {
        GenPersistenceManager pMan = null;
        try {
            pMan = (GenPersistenceManager) Class.forName(loginManager.getPersistenceManagerClassName()).newInstance();
            if (!temporary)
                GenPersistenceManager.setStdInstance(pMan);
            pMan.initPersistenceManager(poolSize);
            GenPersistenceManager.setSpecialInstance(pMan.getClass(), pMan);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
        return pMan;
    }
}