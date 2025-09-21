package com.demo.dubbo.api;

import com.demo.dubbo.model.User;

/**
 * 这是Provider和Consumer都需要依赖的公共接口
 */
public interface UserService {
  User getUserById(Long id);
}
