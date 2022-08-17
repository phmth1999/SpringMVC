package com.springmvc.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.User;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByUsernameAndEnabled(String username, int enabled);
	
	@Query("SELECT u FROM User u ORDER BY u.id DESC")
	Page<User>findAllDataUserSortDESC(Pageable pageable);
	
	@Query("SELECT u FROM User u where u.username=?1")
	User findOneByUsername(String userName);

}
