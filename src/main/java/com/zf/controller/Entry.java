package com.zf.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author  zf
 * Created by Administrator on 2017/11/8.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.zf")
public class Entry {


    public static void main(String[] args) {
        SpringApplication.run(Entry.class,args);
    }
}
