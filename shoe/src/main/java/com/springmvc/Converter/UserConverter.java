package com.springmvc.Converter;

import com.springmvc.Dto.UserDto;
import com.springmvc.Entity.UserEntity;

public class UserConverter {
	public static UserDto toDto(UserEntity userEntity) {
		UserDto userDto = new UserDto();
		userDto.setId(userEntity.getId());
		userDto.setUsername(userEntity.getUsername());
		userDto.setPassword(userEntity.getPassword());
		userDto.setFullname(userEntity.getFullname());
		userDto.setAddress(userEntity.getAddress());
		userDto.setPhone(userEntity.getPhone());
		userDto.setRole(userEntity.getRole());
		userDto.setEnabled(userEntity.getEnabled());
		userDto.setPublickey(userEntity.getPublickey());
		return userDto;
	}
	public static UserEntity toEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(userDto.getUsername());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setFullname(userDto.getFullname());
		userEntity.setAddress(userDto.getAddress());
		userEntity.setPhone(userDto.getPhone());
		userEntity.setRole(userDto.getRole());
		userEntity.setEnabled(userDto.getEnabled());
		userEntity.setPublickey(userDto.getPublickey());
		return userEntity;
	}
}
