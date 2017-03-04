package com.kse.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * 〈数据库接口，实现可以在多个数据库上〉
 *
 * <p>〈功能详细描述〉
 * @author user Feb 28, 2017
 * @see [相关类/方法]
 * @since 1.0
 */
public interface DataBaseDao
{
    /**
     * 根据id查询出对象
     * @param id id值
     * @param dbName
     * @return
     */
    Map findById(String id, String dbName);
    
    /**
     * 插入一个对象的数据
     * @param obj
     * @param dbName
     * @return
     */
    boolean insert(Map obj, String dbName); 
    
    List<Map> find(String dbName);
}
