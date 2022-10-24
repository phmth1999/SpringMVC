package com.springmvc.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Entity.User;

public interface UserService {
	void addAccount(User user) throws Exception;
	Page<User> getAllAccount(Pageable pageable) throws Exception;
	User getAccountById(int id) throws Exception;
	String checkUserName(String userName) throws Exception;
	void addPublicKey(String key, int id) throws Exception;
	void blockUser(int id) throws Exception;
	void editProfile(User user, int id) throws Exception;
}
