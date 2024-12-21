package com.juiceshop.test.executionservice.model;

import lombok.Data;

@Data
public class User {
  String name;
  String email;
  String password;
  String securityQuestion;
  String securityAnswer;
}
