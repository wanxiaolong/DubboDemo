package com.demo.dubbo.provider.service;

import com.demo.dubbo.api.UserService;
import com.demo.dubbo.model.User;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 用户服务实现类。这是Provider提供的具体实现。
 */
// @DubboService注解：
// 1. 这个注解表明这是一个Dubbo服务的实现类
// 2. version属性指定了服务的版本号，方便服务的管理和升级
// 3. 这个注解会让Dubbo在启动时自动注册这个服务到注册中心

// 具体来说，就是在zookeeper的
// /dubbo/com.demo.dubbo.api.UserService/providers节点下创建一个临时节点，比如：
// /dubbo/com.xxx.UserService/providers/dubbo://192.168.1.100:20880/com.xxx.UserService?version=1.0.0&group=default
@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {

  @Override
  public User getUserById(Long id) {
    //简单模拟一个User对象并返回
    if (id == 1L) {
      return new User(1L, "张三", 25, "zhangsan@demo.com");
    } else if (id == 2L) {
      return new User(2L, "李四", 30, "lisi@demo.com");
    } else {
      return new User(id, "未知用户", null, null);
    }
  }
}
