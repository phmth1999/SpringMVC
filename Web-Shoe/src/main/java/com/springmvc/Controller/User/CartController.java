package com.springmvc.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.CartDto;
import com.springmvc.Service.User.CartServiceImpl;

@Controller
public class CartController {
	@Autowired
	private CartServiceImpl cartService;

	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView Index() {
		ModelAndView mav = new ModelAndView("user/cart/list_cart");
		return mav;
	}

	@RequestMapping(value = "/addcart/{id}", method = RequestMethod.GET)
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/editcart/{id}/{quanty}", method = RequestMethod.GET)
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable int id,
			@PathVariable int quanty) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/deletecart/{id}", method = RequestMethod.GET)
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable int id) {
		@SuppressWarnings("unchecked")
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
}
