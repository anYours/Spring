package wul;

import com.Application;
import com.wl.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aa","11");
        Assert.assertEquals("11", stringRedisTemplate.opsForValue().get("aa"));
    }

    @Test
    public void objectTest(){
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUserName(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

    }
}
