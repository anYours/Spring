package com;

import com.model.ConfigurationPropertiesConfig;
import com.model.PropertySourceConfig;
import com.model.ValueConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigTest {

    @Autowired
    private ValueConfig valueConfig;

    @Autowired
    private PropertySourceConfig propertySourceConfig;

    @Autowired
    private ConfigurationPropertiesConfig configurationPropertiesConfig;

    @Test
    public void test1(){
        System.out.println(valueConfig.toString());
    }

    @Test
    public void test2(){
        System.out.println(propertySourceConfig.toString());
    }

    @Test
    public void test3(){
        System.out.println(configurationPropertiesConfig.toString());
    }
}
