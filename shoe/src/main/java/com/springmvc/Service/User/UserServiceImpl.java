package com.springmvc.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.UserRepository;
import com.springmvc.Entity.User;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class UserServiceImpl {
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
		}
	}

	/**
	 * getAllDataUserSortDESC
	 * @return List<User> listUser
	 * @throws Exception
	 **/
	public Page<User> getAllDataUserSortDESC(Pageable pageable) throws Exception {
		Page<User> listUser = null;
		try {
			listUser = userRepository.findAllDataUserSortDESC(pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	/**
	 * getDataUserById
	 * @param int id
	 * @return User user
	 * @throws Exception
	 **/
	public User getDataUserById(int id) throws Exception {
		User user = null;
		try {
			user = userRepository.findOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * findOneByUsername
	 * @param String userName
	 * @return String
	 * @throws Exception
	 **/
	public String findOneByUsername(String userName) throws Exception {
		User entity = null;
		try {
			entity = userRepository.findOneByUsername(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (entity == null) ? "Unique" : "Duplicate";
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
		}
	}
}
