package com.haibao.resconf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.haibao.resconf.mapper"})
@SpringBootApplication
public class ResConfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResConfApplication.class, args);
    }

}
