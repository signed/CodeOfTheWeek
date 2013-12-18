package com.github.signed.codeoftheweek.singleton.db;

import java.util.HashMap;
import java.util.Map;

public abstract class GenPersistenceManager {

    private static GenPersistenceManager standardPersistenceManager;
    private static Map<Class<?>, GenPersistenceManager> persistenceManagerList = new HashMap<Class<?>, GenPersistenceManager>();

    public static void setStdInstance(GenPersistenceManager pm) {
        standardPersistenceManager = pm;
    }

    public static GenPersistenceManager getStdInstance() {
        return standardPersistenceManager;
    }

    protected static void setSpecialInstance(Class<?> persManClass, GenPersistenceManager pm) {
        persistenceManagerList.put(persManClass, pm);
    }

    protected static GenPersistenceManager getSpecialInstance(Class<?> persManClass) {
        return persistenceManagerList.get(persManClass);
    }

    public abstract void initPersistenceManager(int poolsize);
}