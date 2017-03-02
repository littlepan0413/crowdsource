package com.kse.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.kse.dao.DataBaseDao;

/**
* crowdsource
* create by panlu , 2017-02-28 4:41:23 PM
* 
*/
public class MongoDaoImpl implements DataBaseDao
{

    private static final Logger LOG = LoggerFactory
            .getLogger(MongoDaoImpl.class);

    private MongoOperations mongoOperation;

    @Autowired
    public void setMongoOperation(MongoOperations mongoOperation)
    {
        this.mongoOperation = mongoOperation;
    }

    public Map<String, Object> findById(String id, String dbName)
    {
        
        return null;
    }

    public boolean insert(Map<String, Object> obj, String dbName)
    {
        
        return false;
    }

    public List<Map<String, Object>> find(String dbName)
    {
        return null;
    }

}
