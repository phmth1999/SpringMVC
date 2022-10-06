package com.springmvc.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvc.Entity.User;

public interface UserService {
	public void addAccount(User user) throws Exception;
	public Page<User> getAllAccount(Pageable pageable) throws Exception;
	public User getAccountById(int id) throws Exception;
	public String checkUserName(String userName) throws Exception;
	public void addPublicKey(String key, int id) throws Exception;
	public void blockUser(int id) throws Exception;
}
