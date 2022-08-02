package com.springmvc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByUsernameAndEnabled(String username, int enabled);
	
	@Query("SELECT u FROM User u ORDER BY u.id DESC")
	List<User>findAllDataUserSortDESC();
	
	@Query("SELECT u FROM User u where u.username=?1")
	User findOneByUsername(String userName);
}
