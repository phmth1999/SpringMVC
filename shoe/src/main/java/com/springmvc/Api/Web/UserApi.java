package com.springmvc.Api.Web;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.Controller.Admin.UserController;
import com.springmvc.Dto.ResponseObject;
import com.springmvc.Dto.UserDto;
import com.springmvc.Services.IUserService;

@RestController("ApiUser")
@RequestMapping("/api")
public class UserApi {
	
	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@GetMapping("/user")
	ResponseEntity<ResponseObject> findAllAccount() throws Exception {
		List<UserDto> listUsers = new ArrayList<UserDto>();
		ResponseEntity<ResponseObject> responseEntity = null;
		try {
			Pageable pageable = new PageRequest(0, Integer.MAX_VALUE);
			Page<UserDto> page = userService.getAllAccount(pageable);
			listUsers = page.getContent();
			if(listUsers != null){
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "successfully", listUsers));
			}else{
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Cannot find user", listUsers));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return responseEntity;
	}
	@GetMapping("/user/{id}")
	ResponseEntity<ResponseObject> findAccountById(@PathVariable("id") int id) throws Exception {
		UserDto user = new UserDto();
		ResponseEntity<ResponseObject> responseEntity = null;
		try {
			user = userService.getAccountById(id);
			if(user != null){
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "successfully", user));
			}else{
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Cannot find user with id = "+id, user));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return responseEntity;
	}
	@PostMapping("/user")
	ResponseEntity<ResponseObject> insertAccount(@RequestBody UserDto user) throws Exception {
		ResponseEntity<ResponseObject> responseEntity = null;
		UserDto newUser = new UserDto();
		try {
			if(userService.checkUserName(user.getUsername()).equals("Duplicate")){
				responseEntity = ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject("failed", "Username exists la : "+user.getUsername(), user));
			}else{
				newUser = userService.addAccount(user);
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "successfully", newUser));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return responseEntity;
	}
	@PutMapping("/user/{id}")
	ResponseEntity<ResponseObject> updateAccount(@RequestBody UserDto user, @PathVariable("id") int id) throws Exception {
		ResponseEntity<ResponseObject> responseEntity = null;
		try {
			if(userService.getAccountById(id) != null){
				userService.editProfile(user, id);
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "successfully", user));
			}else{
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Cannot find user with id = "+id, user));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return responseEntity;
	}
	@DeleteMapping("/user/{id}")
	ResponseEntity<ResponseObject> deleteAccount(@PathVariable("id") int id) throws Exception {
		ResponseEntity<ResponseObject> responseEntity = null;
		try {
			if(userService.getAccountById(id) != null){
				userService.blockUser(id);
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "successfully", userService.getAccountById(id)));
			}else{
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "Cannot delete user with id = "+id, userService.getAccountById(id)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return responseEntity;
	}
}
