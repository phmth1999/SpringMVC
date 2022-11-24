package com.springmvc.Controller.Web.Api;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.CartDto;
import com.springmvc.Services.ICartService;

@Controller("WebCart")
public class CartApi {
	
	final static Logger logger = Logger.getLogger(CartApi.class);
	
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

	@SuppressWarnings("unchecked")
	@PostMapping("/api/addcart/{id}")
	@ResponseBody
	public HashMap<Integer, CartDto> AddCart(HttpServletRequest request, HttpSession session, @PathVariable int id) throws Exception {
		HashMap<Integer, CartDto> cart = new HashMap<>();
		try {	
			cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
			if (cart == null) {
				cart = new HashMap<Integer, CartDto>();
			}
			if(request.getParameter("quanty")!=null){
				int quanty = Integer.parseInt(request.getParameter("quanty").toString());
				cart = cartService.AddCart(id, cart, quanty);
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
		return cart;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/api/editcart/{id}/{quanty}")
	@ResponseBody
	public HashMap<Integer, CartDto> EditCart(HttpServletRequest request, HttpSession session, @PathVariable int id, @PathVariable int quanty) throws Exception {
		HashMap<Integer, CartDto> cart = new HashMap<>();
		try {
			cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
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
		return cart;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/api/deletecart/{id}")
	@ResponseBody
	public HashMap<Integer, CartDto> DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable int id) throws Exception {
		HashMap<Integer, CartDto> cart = new HashMap<>();
		try {
			cart = (HashMap<Integer, CartDto>) session.getAttribute("Cart");
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
		return cart;
	}
}
