package com.kse.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * gson解析器工厂类
 *
 * <p>
 * 所有的gson优化都在此完成
 * 
 * @author panlu 2016年11月30日
 * @see [相关类/方法]
 * @since 1.0
 */
public class GsonFactory
{
    private static Gson gson;

    static
    {
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    }

    /**
     * 可能有性能问题，共用一个gson
     * 
     * @return
     */
    public static Gson getGsonClient()
    {
        return gson;
    }
}
