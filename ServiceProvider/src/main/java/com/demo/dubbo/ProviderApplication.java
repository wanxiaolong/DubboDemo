package com.demo.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//这里声明要扫描的实现类所在的包
@EnableDubbo(scanBasePackages = "com.demo.dubbo.provider.service")
public class ProviderApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
    System.out.println("Dubbo Provider启动成功");
  }
}