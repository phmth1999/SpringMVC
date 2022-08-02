package com.springmvc.Service.User;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.UserRepository;
import com.springmvc.Entity.User;

@Service
public class UserServiceImpl {
	@Autowired
	private UserRepository userRepository;

	public User addAccount(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		user.setRole("ROLE_USER");
		user.setEnabled(1);
		return userRepository.save(user);
	}

	public List<User> getAllDataUserSortDESC() {
		return userRepository.findAllDataUserSortDESC();
	}
	
	public User getDataUserById(int id){
		return userRepository.findOne(id);
	}
	
	public String findOneByUsername(String userName) {
		User entity = userRepository.findOneByUsername(userName);
		return (entity == null) ? "Unique" : "Duplicate";
	}
	public User addPublicKey(String key, int id){
		User user = userRepository.findOne(id);
		user.setPublickey(key);
		return userRepository.save(user);
	}
}
