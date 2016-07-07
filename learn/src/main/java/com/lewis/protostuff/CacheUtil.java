package com.lewis.protostuff;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by zhangminghua on 2016/6/13.
 */
public class CacheUtil {
    private static final String my_redis_host="192.168.183.132";
    private static final String remote_redis_host="redis1.tuniu-cie.org";

    private static JedisPool jedisPool = new JedisPool(remote_redis_host,6379);

    public static void setCacheBytes(String key,Object value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            byte[] valueBytes = ProtoStuffSerializerUtil.serialize(value);
            byte[] keyBytes = ProtoStuffSerializerUtil.serialize(key);
            String setex = jedis.setex(keyBytes, 60, valueBytes);
        } catch (Exception e) {

        }finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        }
    }

    public static void setCache(String key,Object value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key, 60, JSON.toJSONString(value));
        } catch (Exception e) {

        }finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        }
    }

    public static <T> T  getCacheBytes(String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            byte[] bytes = jedis.get(ProtoStuffSerializerUtil.serialize(key));
            T t = ProtoStuffSerializerUtil.deserializer(bytes, clazz);
            return t;
        } catch (Exception e) {

        }finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        }
        return null;
    }

    public static <T> T  getCache(String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String valueString = jedis.get(key);
            T t = JSON.parseObject(valueString,clazz);
            return t;
        } catch (Exception e) {

        }finally {
            if (jedis != null) {
                jedisPool.returnResource(jedis);
            }
        }
        return null;
    }


}
