package com.github.signed.codeoftheweek.singleton.publictransportation;

import com.github.signed.codeoftheweek.singleton.db.GenPersistenceManager;

public class PersistenceManager extends GenPersistenceManager {
    public static PersistenceManager getInstance() {
        return (PersistenceManager) getSpecialInstance(PersistenceManager.class);
    }

    @Override
    public void initPersistenceManager(int poolsize) {

    }
}