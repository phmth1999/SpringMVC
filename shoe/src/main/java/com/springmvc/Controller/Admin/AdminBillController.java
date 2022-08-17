package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.Bill;
import com.springmvc.Service.User.BillServiceImpl;

@Controller
public class AdminBillController {

	@Autowired
	private BillServiceImpl billServiceImpl;
	

	@RequestMapping(value = "/quan-tri/bill", method = RequestMethod.GET)
	public ModelAndView ListBill(HttpServletRequest request, HttpSession session) throws Exception {
		int pageNum = 1;
		if(request.getParameter("page")!=null){
		pageNum = Integer.parseInt(request.getParameter("page").toString());
		}
		Pageable pageable = new PageRequest((pageNum - 1), 6);
		Page<Bill> page = billServiceImpl.getAllDataBillSortDESC(pageable);
		List<Bill> listPageBills = page.getContent();
		ModelAndView mav = new ModelAndView("admin/bill/list");
		session.setAttribute("page", pageNum);
		mav.addObject("currentPage", pageNum);
		mav.addObject("previous", pageNum-1);
		mav.addObject("next", pageNum+1);
		mav.addObject("totalPages", page.getTotalPages());
	    mav.addObject("totalItems", page.getTotalElements());
		mav.addObject("listPageBills", listPageBills);
		return mav;
	}
	@RequestMapping(value = "/quan-tri/bill-detail", method = RequestMethod.GET)
	public ModelAndView ListBillDetail(HttpServletRequest request, HttpSession session) throws Exception {
		request.setAttribute("page", Integer.parseInt(session.getAttribute("page").toString()));
		session.removeAttribute("page");
		int idBill = Integer.parseInt(request.getParameter("idBill").toString());
		ModelAndView mav = new ModelAndView("admin/bill/list-detail");
			mav.addObject("billDetail", billServiceImpl.getBillDetailByIdUserLogin(idBill));
		return mav;
	}

}
