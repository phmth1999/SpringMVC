package com.springmvc.Service.Security;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvc.Entity.UserEntity;
import com.springmvc.Repositories.UserRepository;
import com.springmvc.Security.MyUser;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	final static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser myUser = null;
		try {
			UserEntity user = userRepository.findOneByUsernameAndEnabled(username, 1);

			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

			myUser = new MyUser(user.getUsername(), user.getPassword(), grantedAuthorities);
			myUser.setId(user.getId());
			myUser.setFullName(user.getFullname());
			myUser.setEmail(user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return myUser;
	}

}
