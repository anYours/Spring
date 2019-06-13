package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static StringRedisTemplate template;
    private static RedisTemplate<String, Object> template1;

    @PostConstruct
    public void init(){
        RedisUtil.template = this.stringRedisTemplate;
        RedisUtil.template1 = this.redisTemplate;
    }

    /**
     * 判断键是否在redis中存在
     * @param key
     * @return
     */
    public static boolean isCacheExists(String key){
        boolean flag = false;
        Set<String> keys = template.keys(key);
        if(null != keys && !key.isEmpty()){
            flag = true;
        }
        return flag;
    }

    /**
     * 设置有效期
     * @param key   键
     * @param time  有效期
     */
    public static void expire(String key, long time){
        try{
            if(time > 0){
                template.expire(key, time, TimeUnit.SECONDS);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取某个键的有效期
     * @param key   键名
     * @return
     */
    public static long getExpire(String key){
        Long expire = template.getExpire(key);
        return expire;
    }

    /**
     * 缓存数据
     * @param key
     * @param listData
     * @param time
     */
    public static void updateCacheById(String key, Object[] listData, long time){
        try{
            template1.delete(key);
            ValueOperations<String, Object> valueOps =  template1.opsForValue();
            valueOps.set(key, listData);
            if(time > 0){
                template1.expire(key, time, TimeUnit.SECONDS);
            }
        }catch (Throwable t){
            t.printStackTrace();
        }
    }

    /**
     * 获取缓存内容
     * @param key
     * @return
     */
    public static Object getValueByKey(String key){
        Object obj = null;
        try{
            obj = template1.opsForValue().get(key);
        }catch (Throwable t){
            t.printStackTrace();
        }
        return obj;
    }

}
