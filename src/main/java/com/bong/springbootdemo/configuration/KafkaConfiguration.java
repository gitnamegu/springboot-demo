package com.bong.springbootdemo.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * kafka配置类
 * @author dabing
 * @create 2018/11/10
 * @since 1.0.0
 */
@Component  // 该类作为一个组件类
@ConfigurationProperties(prefix = "kafka")  // 从配置文件中拿到kafka的相关配置。如果专门写了个类跟配置文件映射就使用这个注解
@PropertySource(value = {"classpath:kafka.properties"}) // @ConfigurationProperties默认从主配置文件中获取信息，而这个注解可以指定配置文件
@Data // lombok的注解，顶在类上，提供get/set/toString/equals/hashcode方法
public class KafkaConfiguration {

    private String address;
    private String prot;
    private String addressDecription;
}
