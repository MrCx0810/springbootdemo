package com.ch.services.imp.admin;


import com.ch.services.interf.admin.CacheManagerInter;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/25
 * @Time: 21:45
 * To change this template use File | Settings | File Templates.
 */

@Service
public class CacheManagerImp implements CacheManagerInter {
//
//	@Resource
//	private  JedisConnectionFactory jedisConnectionFactory;
//	@Override
//	public void clearCache() {
//		JedisConnection connection = null;
//        try{
//            connection = jedisConnectionFactory.getConnection();
//            connection.flushDb();
//            connection.flushAll();
//        }
//        catch (JedisConnectionException e){
//            e.printStackTrace();
//        }
//        finally{
//            if (connection != null) {
//                connection.close();
//            }
//        }
//	}
//	@Override
//	public void putCash(Object key, Object value) {
//		JedisConnection connection = null;
//        try{
//            connection = jedisConnectionFactory.getConnection();
//            String str = String.valueOf(key);
//            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
//            connection.set(str.getBytes(), serializer.serialize(value));
//        }
//        catch (JedisConnectionException e){
//            e.printStackTrace();
//        }
//        finally{
//            if (connection != null) {
//                connection.close();
//            }
//        }
//
//	}
//	@Override
//	public void clearCash(Object key, Object value) {
//		JedisConnection connection = null;
//        try{
//            connection = jedisConnectionFactory.getConnection();
//            String str = String.valueOf(key);
//            connection.del(str.getBytes());
//        }
//        catch (JedisConnectionException e){
//            e.printStackTrace();
//        }
//        finally{
//            if (connection != null) {
//                connection.close();
//            }
//        }
//
//	}
//	@Override
//	public Object getCash(Object key) {
//		JedisConnection connection = null;
//		Object result = null;
//        try{
//            connection = jedisConnectionFactory.getConnection();
//            String str = String.valueOf(key);
//            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
//            result = serializer.deserialize(connection.get(str.getBytes()));
//        }
//        catch (JedisConnectionException e){
//            e.printStackTrace();
//        }
//        finally{
//            if (connection != null) {
//                connection.close();
//            }
//        }
//        return result;
//	}
}
