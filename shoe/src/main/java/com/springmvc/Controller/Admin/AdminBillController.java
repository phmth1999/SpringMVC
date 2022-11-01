package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.BillEntity;
import com.springmvc.Service.BillService;

@Controller
public class AdminBillController {
	
	final static Logger logger = Logger.getLogger(AdminBillController.class);
	
	@Autowired
	private BillService billService;
	
	private int checkPage(HttpServletRequest request, int pageNum) throws Exception{
		try {
			if (request.getParameter("page") != null) {
				pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return pageNum;
	}

	@GetMapping("/quan-tri/bill")
	public ModelAndView ListBill(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int pageNum = 1;
			Sort sort =  new Sort(Sort.Direction.DESC, "id");
			Pageable pageable = new PageRequest((checkPage(request, pageNum) - 1), 6, sort);
			Page<BillEntity> page = billService.getAllBill(pageable);
			List<BillEntity> listPageBills = page.getContent();
			mav = new ModelAndView("admin/bill/list");
			session.setAttribute("page", checkPage(request, pageNum));
			mav.addObject("currentPage", checkPage(request, pageNum));
			mav.addObject("previous", checkPage(request, pageNum)-1);
			mav.addObject("next", checkPage(request, pageNum)+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
			mav.addObject("listPageBills", listPageBills);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@GetMapping("/quan-tri/bill-detail")
	public ModelAndView ListBillDetail(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			request.setAttribute("page", Integer.parseInt(session.getAttribute("page").toString()));
			session.removeAttribute("page");
			int idBill = Integer.parseInt(request.getParameter("idBill").toString());
			mav = new ModelAndView("admin/bill/list-detail");
			mav.addObject("billDetail", billService.getBillDetailByIdUserLogin(idBill));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

}
