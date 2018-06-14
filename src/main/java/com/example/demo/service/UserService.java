package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface UserService {

	boolean insert(UserEntity userEntity);

	UserEntity getByUsername(String username);
}
