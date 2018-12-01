package com.bong.springbootdemo;

import com.bong.springbootdemo.configuration.KafkaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    private KafkaConfiguration kafkaConfiguration;

    @Test
    public void contextLoads() {
        System.out.println(kafkaConfiguration);
    }

    @Test
    public void dataSource() {
        System.out.println("=====");
        System.out.println(dataSource.getClass());
        System.out.println("=====");
    }

}
