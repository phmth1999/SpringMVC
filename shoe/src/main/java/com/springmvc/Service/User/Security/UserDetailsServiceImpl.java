package com.springmvc.Service.User.Security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.UserRepository;
import com.springmvc.Entity.User;
import com.springmvc.Security.MyUser;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * loadUserByUsername
	 * @param String username
	 * @return MyUser myUser
	 * @throws UsernameNotFoundException
	 **/
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userRepository.findOneByUsernameAndEnabled(username, 1);

			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

			MyUser myUser = new MyUser(user.getUsername(), user.getPassword(), grantedAuthorities);
			myUser.setId(user.getId());
			myUser.setFullName(user.getFullname());
			myUser.setEmail(user.getUsername());
		return myUser;
	}

}
