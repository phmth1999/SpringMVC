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
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class UserServiceImpl implements UserService{
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * addAccount
	 * @param User user
	 * @throws Exception
	 **/
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

	/**
	 * getAllDataUserSortDESC
	 * @return List<User> listUser
	 * @throws Exception
	 **/
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
	
	/**
	 * getDataUserById
	 * @param int id
	 * @return User user
	 * @throws Exception
	 **/
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
	
	/**
	 * checkUserName
	 * @param String userName
	 * @return boolean
	 * @throws Exception
	 **/
	public boolean checkUserName(String userName) throws Exception {
		boolean valid = false;
		try {
			if(userRepository.findOneByUsername(userName) != null){
				valid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return valid;
	}
	
	/**
	 * addPublicKey
	 * @param String key
	 * @param int id
	 * @throws Exception
	 **/
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
	/**
	 * blockUser
	 * @param int id
	 * @throws Exception
	 **/
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
	/**
	 * editProfile
	 * @param User user
	 * @param int id
	 * @throws Exception
	 **/
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
