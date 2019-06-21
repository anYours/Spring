package com.test;

import com.wl.dao.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test1(){
        System.out.println("1111");
    }
}
