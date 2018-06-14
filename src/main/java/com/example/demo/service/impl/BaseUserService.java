package com.example.demo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.RoleConstant;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.wapper.UserMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Primary
@Log4j2
public class BaseUserService implements UserService {

	private final UserMapper userMapper;

	public BaseUserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public boolean insert(UserEntity userEntity) {
		String username = userEntity.getUsername();
		if (exist(username))
			return false;
		String password = userEntity.getPassword();
		userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
		userEntity.setRoles(RoleConstant.ROLE_USER);
		log.info(userEntity.toString());
		int result = userMapper.insert(userEntity);
		return result == 1;
	}

	@Override
	public UserEntity getByUsername(String username) {
		return userMapper.selectByUsername(username);
	}

	private boolean exist(String username) {
		UserEntity userEntity = userMapper.selectByUsername(username);
		return userEntity != null;
	}

}
