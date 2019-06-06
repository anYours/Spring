package com.wl.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Value("${test.myName}")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test(){}

    @Value("${test.secret}")
    private String secret;
    @Value("${test.number}")
    private Integer number;
    @Value("${test.bignumber}")
    private Long bignumber;
    @Value("${test.uuid}")
    private String uuid;
    @Value("${test.ten}")
    private Integer ten;
    @Value("${test.range}")
    private Integer range;

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", secret='" + secret + '\'' +
                ", number=" + number +
                ", bignumber=" + bignumber +
                ", uuid='" + uuid + '\'' +
                ", ten=" + ten +
                ", range=" + range +
                '}';
    }
}
