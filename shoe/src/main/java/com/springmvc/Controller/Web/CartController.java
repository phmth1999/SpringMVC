package com.springmvc.Controller.Web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.CartDto;
import com.springmvc.Services.ICartService;

@Controller
public class CartController {
	
	final static Logger logger = Logger.getLogger(CartController.class);
	
	@Autowired
	private ICartService cartService;

	@GetMapping("/gio-hang")
	public ModelAndView Index() throws Exception{
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("web/cart/list_cart");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@GetMapping("/addcart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id) throws Exception {
		String mav = "";
		try {
			mav = "redirect:" + request.getHeader("Referer");
			@SuppressWarnings("unchecked")
			HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			if (cart == null) {
				cart = new HashMap<Integer, CartDto>();
			}
			if(request.getParameter("quanty")!=null){
				int quanty = Integer.parseInt(request.getParameter("quanty").toString());
				cart = cartService.AddCart(id, cart, quanty);
				session.setAttribute("quanty", quanty);
			}else{
				cart = cartService.AddCart(id, cart, 1);
			}
			session.setAttribute("Cart", cart);
			session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
			session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@GetMapping("/editcart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable int id, @PathVariable int quanty) throws Exception {
		String mav = "";
		try {
			mav = "redirect:" + request.getHeader("Referer");
			@SuppressWarnings("unchecked")
			HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			if (cart == null) {
				cart = new HashMap<Integer, CartDto>();
			}
			cart = cartService.EditCart(id, quanty, cart);
			session.setAttribute("Cart", cart);
			session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
			session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

	@GetMapping("/deletecart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable int id) throws Exception {
		String mav = "";
		try {
			mav = "redirect:" + request.getHeader("Referer");
			@SuppressWarnings("unchecked")
			HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			if (cart == null) {
				cart = new HashMap<Integer, CartDto>();
			}
			cart = cartService.DeleteCart(id, cart);
			session.setAttribute("Cart", cart);
			session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
			session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
}
