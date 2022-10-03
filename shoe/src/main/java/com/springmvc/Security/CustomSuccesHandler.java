package com.springmvc.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
public class CustomSuccesHandler extends SimpleUrlAuthenticationSuccessHandler {
	final static Logger logger = Logger.getLogger(CustomSuccesHandler.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	/**
	 * handle
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @param Authentication authentication
	 * @return void
	 * @throws ServletException 
	 * @throws IOException 
	 **/
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		try {
			determineTargetUrl(authentication);
			if (response.isCommitted()) {
				return;
			}
			super.handle(request, response, authentication);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * getRedirectStrategy
	 * @return RedirectStrategy redirectStrategy
	 **/
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	/**
	 * setRedirectStrategy
	 * @param RedirectStrategy redirectStrategy
	 * @return void
	 **/
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	/**
	 * getPrincipal
	 * @return MyUser myUser
	 * @throws Exception
	 **/
	public static MyUser getPrincipal()throws Exception {
		MyUser myUser = null;
		try {
			myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return myUser;
	}

	/**
	 * getAuthorities
	 * @return List<String> results
	 * @throws Exception
	 **/
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() throws Exception{
		List<String> results = new ArrayList<String>();
		try {
			List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
					.getAuthentication().getAuthorities());
			for (GrantedAuthority authority : authorities) {
				results.add(authority.getAuthority());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return results;
	}

	/**
	 * determineTargetUrl
	 * @param Authentication authentication
	 * @return String url
	 * @throws Exception 
	 **/
	private String determineTargetUrl(Authentication authentication) throws Exception {
		String url = "";
		try {
			List<String> roles = getAuthorities();
			if (isAdmin(roles)) {
				url = "/quan-tri/trang-chu";
			} else if (isUser(roles)) {
				url = "/trang-chu";
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return url;
	}

	/**
	 * isAdmin
	 * @param List<String> roles
	 * @return boolean
	 * @throws Exception 
	 **/
	private boolean isAdmin(List<String> roles) throws Exception {
		try {
			if (roles.contains("ROLE_ADMIN")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}

	/**
	 * isUser
	 * @param List<String> roles
	 * @return boolean
	 * @throws Exception
	 **/
	private boolean isUser(List<String> roles) throws Exception{
		try {
			if (roles.contains("ROLE_USER")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return false;
	}
}
