package com.bong.springbootdemo.pojo;

import lombok.Data;

/**
 * idea安装lombok插件
 * @author dabing
 * @create 2018/11/10
 * @since 1.0.0
 */
@Data
public class User {

    private int id;
    private String name;
    private String password;

}
