package com.demo.dubbo;

import com.demo.dubbo.api.UserService;
import com.demo.dubbo.model.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConsumerApplication {

  // 解释@DubboReference注解：
  // 1. 这个注解用于引用远程的Dubbo服务
  // 2. version属性指定了要引用的服务版本，必须和Provider提供的版本一致
  // 3. Dubbo会自动生成一个代理对象，通过这个代理对象调用远程服务
  // 4. 它会让Spring在启动时自动注入这个代理对象
  // 5. 通过这个注解，Consumer不需要关心服务的具体实现和网络通信细节
  // 6. 这样就实现了服务的解耦和模块化
  // 7. Consumer只需要依赖公共的接口和模型类
  // 8. 这样可以方便地进行服务的升级和维护，也可以支持多版本共存

  // 这个注解会向注册中心订阅UserService服务，对应zookeeper的
  // /dubbo/com.demo.dubbo.api.UserService/providers节点

  // 注册中心会将当前可用的rPovider节点信息推送给Consumer
  // Consumer会基于负载均衡策略选择一个Provider节点进行远程调用
  @DubboReference(version = "1.0.0")
  private UserService userService;

  @GetMapping("/user/{id}")
  public User getUser(@PathVariable Long id) {
    //调用远程Dubbo服务
    return userService.getUserById(id);
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
    System.out.println("Dubbo Consumer启动成功");
  }
}
