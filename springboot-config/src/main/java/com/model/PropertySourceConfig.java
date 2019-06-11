package com.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:test_application.yml")
public class PropertySourceConfig {

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
