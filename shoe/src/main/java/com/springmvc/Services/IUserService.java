package com.springmvc.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Dto.UserDto;

public interface IUserService {
	UserDto addAccount(UserDto user) throws Exception;
	Page<UserDto> getAllAccount(Pageable pageable) throws Exception;
	UserDto getAccountById(int id) throws Exception;
	String checkUserName(String userName) throws Exception;
	void addPublicKey(String key, int id) throws Exception;
	void blockUser(int id) throws Exception;
	void editProfile(UserDto user, int id) throws Exception;
}
