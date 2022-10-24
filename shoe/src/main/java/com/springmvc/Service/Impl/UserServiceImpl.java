package com.springmvc.Service.Impl;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.UserRepository;
import com.springmvc.Entity.User;
import com.springmvc.Service.UserService;
@Service
public class UserServiceImpl implements UserService{
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	
	public void addAccount(User user) throws Exception {
		try {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
			user.setRole("ROLE_USER");
			user.setEnabled(1);
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	public Page<User> getAllAccount(Pageable pageable) throws Exception {
		Page<User> listUser = null;
		try {
			listUser = userRepository.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listUser;
	}
	
	public User getAccountById(int id) throws Exception {
		User user = null;
		try {
			user = userRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return user;
	}
	
	public String checkUserName(String userName) throws Exception {
		User entity = null;
		try {
			entity = userRepository.findOneByUsername(userName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return (entity == null) ? "Unique" : "Duplicate";
	}
	
	public void addPublicKey(String key, int id) throws Exception {
		User user = null;
		try {
			user = userRepository.findOne(id);
			user.setPublickey(key);
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void blockUser(int id) throws Exception{
		User user = null;
		try {
			user = userRepository.findOne(id);
			if(user.getEnabled() == 1){
				user.setEnabled(0);
			}else if(user.getEnabled() == 0){
				user.setEnabled(1);
			}
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void editProfile(User user, int id) throws Exception{
		try {
			User userLogin = userRepository.findOne(id);
			userLogin.setFullname(user.getFullname());
			userLogin.setAddress(user.getAddress());
			userLogin.setPhone(user.getPhone());
			userLogin.setPublickey(user.getPublickey());
			userRepository.save(userLogin);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}
