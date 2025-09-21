package com.demo.dubbo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 注意：Dubbo传输对象需要实现Serializable接口
public class User implements Serializable {
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
