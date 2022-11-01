package com.springmvc.Service.Impl;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springmvc.Converter.UserConverter;
import com.springmvc.Dto.UserDto;
import com.springmvc.Entity.UserEntity;
import com.springmvc.Repositories.UserRepository;
import com.springmvc.Service.UserService;
@Service
public class UserServiceImpl implements UserService{
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	
	public UserDto addAccount(UserDto userDto) throws Exception {
		UserEntity userEntity = new UserEntity();
		try {
			userDto.setPassword(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(12)));
			userDto.setRole("ROLE_USER");
			userDto.setEnabled(1);
			userEntity = UserConverter.toEntity(userDto);
			userRepository.save(userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return userDto;
	}

	public Page<UserDto> getAllAccount(Pageable pageable) throws Exception {
		Page<UserDto> listUserDto = null;
		try {
			Page<UserEntity> listUserEntity = userRepository.findAll(pageable);
			listUserDto = listUserEntity.map(new Converter<UserEntity, UserDto>() {
				@Override
				public UserDto convert(UserEntity userEntity) {
					UserDto userDto = UserConverter.toDto(userEntity);
					return userDto;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listUserDto;
	}
	
	public UserDto getAccountById(int id) throws Exception {
		UserDto userDto = null;
		try {
			UserEntity userEntity = userRepository.findOne(id);
			userDto = UserConverter.toDto(userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return userDto;
	}
	
	public String checkUserName(String userName) throws Exception {
		Boolean valid = false;
		String res = "";
		try {
			valid = userRepository.existsByUsername(userName);
			if(valid == false){
				res = "Unique";
			}else{
				res = "Duplicate";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return res;
	}
	
	public void addPublicKey(String key, int id) throws Exception {
		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findOne(id);
			userEntity.setPublickey(key);
			userRepository.save(userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void blockUser(int id) throws Exception{
		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findOne(id);
			if(userEntity.getEnabled() == 1){
				userEntity.setEnabled(0);
			}else if(userEntity.getEnabled() == 0){
				userEntity.setEnabled(1);
			}
			userRepository.save(userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	public void editProfile(UserDto userDto, int id) throws Exception{
		try {
			UserEntity userEntity = userRepository.findOne(id);
			userEntity.setFullname(userDto.getFullname());
			userEntity.setAddress(userDto.getAddress());
			userEntity.setPhone(userDto.getPhone());
			userEntity.setPublickey(userDto.getPublickey());
			userRepository.save(userEntity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}
