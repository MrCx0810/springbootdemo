package com.ch.until.phone;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

    private static Map<String,Object> session = new ConcurrentHashMap<>();

    public static void add(String key,Object value){
        session.put(key,value);
    }
    public static Object getValue(String key){
        return session.get(key);
    }
}
