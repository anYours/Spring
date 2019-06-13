package wul;

import com.Application;
import com.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    private com.bean.Test test;

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

    @Test
    public void test7(){
        Integer value = 200;
        BigDecimal maxValue = BigDecimal.valueOf(1000L);
        boolean b = new BigDecimal(value.toString()).compareTo(maxValue) != 1;
        System.out.println(b);
    }

    public static void main(String[] args) {
        int[] intArr = {1,6,78,4,5,94,105,3,666,55,88,7};
        int length = intArr.length;
        //外层：需要length-1次循环比较
        for (int i = 0; i < length - 1; i++) {
            //内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
            for (int j = 0; j < length - 1 - i; j++) {
                if (intArr[j] > intArr[j+1]) {
                    //交换数组array的j和j+1位置的数据
                    swap(intArr, j, j+1);
                }
            }
        }
        System.out.println(intArr);
    }

    /**
     * 交换数组array的i和j位置的数据
     * @param array 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
