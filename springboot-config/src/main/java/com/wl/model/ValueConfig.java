package com.wl.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 访问默认的配置文件中的配置项，强制字段必须对应在配置文件
 */
@Component
public class ValueConfig {

    @Value("${demo.test.name}")
    private String name;

    @Value("${demo.test.des}")
    private String des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "ValueConfig{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
