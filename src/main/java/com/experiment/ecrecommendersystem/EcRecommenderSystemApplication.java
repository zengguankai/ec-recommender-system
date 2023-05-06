package com.experiment.ecrecommendersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.experiment.ecrecommendersystem"})
@MapperScan("com.experiment.ecrecommendersystem.dal")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class EcRecommenderSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcRecommenderSystemApplication.class, args);
    }

}
