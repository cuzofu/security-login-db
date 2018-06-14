package com.example.demo.entity;

import lombok.Data;

@Data
public class UserEntity {

	private Long id;

	private String username;

	private String password;

	private String nickname;

	private String roles;

}
