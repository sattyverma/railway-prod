package com.example.demo.service;

import com.example.demo.entity.User;

import Userapplication.dto.UserDto;

public interface UserService {

	User findByUsername(String username);
	User save(UserDto userDto);
}
