package com.springmvc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Entity.UserEntity;
@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findOneByUsernameAndEnabled(String username, int enabled);
	
	UserEntity findOneByUsername(String userName);
	
	Boolean existsByUsername(String username);

	Boolean existsByPhone(String phone);

	Boolean existsByEmail(String email);

}
