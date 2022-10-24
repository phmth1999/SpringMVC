package com.springmvc.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByUsernameAndEnabled(String username, int enabled);
	
	User findOneByUsername(String userName);

}
