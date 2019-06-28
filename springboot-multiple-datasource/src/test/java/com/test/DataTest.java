package com.test;

import com.bean.PinYin;
import com.service.impl.PinYinImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTest {

    @Autowired
    private PinYinImpl pinYinService;

    @Test
    public void test1(){
        List<PinYin> pinYins = pinYinService.getPinYins();
        System.out.println(pinYins);
    }

    @Test
    public void test2(){
        PinYin pinYin = new PinYin();
        pinYin.setPy("123234234123");
        pinYinService.savePinYin(pinYin);
    }
}
