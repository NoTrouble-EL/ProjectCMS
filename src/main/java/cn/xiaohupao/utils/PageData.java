package cn.xiaohupao.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/11/3 13:55
 */
public class PageData extends HashMap{

    private Map map;

    public PageData(){
        this.map = new HashMap();
    }

    public String getString(Object key){
        return String.valueOf(map.get(key));
    }

    @Override
    public Object put(Object key, Object value){
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key){
        return map.remove(key);
    }

    @Override
    public int size(){
        return map.size();
    }
}
