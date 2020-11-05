package cn.zcj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
*  spring boot工程都有一个启动引导类，是工程的入口类
*  需要在引导类上添加注解SpringBootApplication
* */

@SpringBootApplication
/*Mybatis官方扫描mybatis所以的业务mapper接口*//*
@MapperScan("cn.zcj.Mapper")*/
/*TKMapper,用法和官方的一致*/
@MapperScan("cn.zcj.Mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
