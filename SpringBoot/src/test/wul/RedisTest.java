package wul;

import com.Application;
import com.wl.bean.User;
import com.wl.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private com.wl.bean.Test test;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aa","11");
        Assert.assertEquals("11", stringRedisTemplate.opsForValue().get("aa"));
    }

    @Test
    public void objectTest(){

    }

    @Test
    public void test1(){
        String key = "超人";
        boolean cacheExists = RedisUtil.isCacheExists(key);
        System.out.println(cacheExists);
    }

    @Test
    public void test2(){
        String key = "超人";
        long time = 23123L;
        RedisUtil.expire(key, time);
        long expire = RedisUtil.getExpire(key);
        System.out.println(expire);
    }

    @Test
    public void test3(){
        String key = "attr";
        long time = 2313L;
        Object[] ints = {1, 2, 3, 4};
        RedisUtil.updateCacheById(key, ints, time);
    }

    @Test
    public void test4(){
        String key = "attr";
        Object valueByKey = RedisUtil.getValueByKey(key);
        System.out.println(valueByKey);
    }

    @Test
    public void test5(){
        String key = "list";
        List<Object> values = new ArrayList<Object>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        redisTemplate.opsForList().rightPush(key, values);
//        List<Object> list = redisTemplate.opsForList().range(key, 0, -1);
        List<Object> list = redisTemplate.opsForList().range(key, 0, -1);
        System.out.println(list);
    }

    @Test
    public void test6(){
        System.out.println(test.toString());
    }
}
