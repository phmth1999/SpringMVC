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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Entity.Bill;
import com.springmvc.Service.Impl.BillServiceImpl;

@Controller
public class AdminBillController {
	final static Logger logger = Logger.getLogger(AdminBillController.class);
	
	@Autowired
	private BillServiceImpl billServiceImpl;
	

	@RequestMapping(value = "/quan-tri/bill", method = RequestMethod.GET)
	public ModelAndView ListBill(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int pageNum = 1;
			if(request.getParameter("page")!=null){
			pageNum = Integer.parseInt(request.getParameter("page").toString());
			}
			Sort sort =  new Sort(Sort.Direction.DESC, "id");
			Pageable pageable = new PageRequest((pageNum - 1), 6, sort);
			Page<Bill> page = billServiceImpl.getAllBill(pageable);
			List<Bill> listPageBills = page.getContent();
			mav = new ModelAndView("admin/bill/list");
			session.setAttribute("page", pageNum);
			mav.addObject("currentPage", pageNum);
			mav.addObject("previous", pageNum-1);
			mav.addObject("next", pageNum+1);
			mav.addObject("totalPages", page.getTotalPages());
		    mav.addObject("totalItems", page.getTotalElements());
			mav.addObject("listPageBills", listPageBills);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@RequestMapping(value = "/quan-tri/bill-detail", method = RequestMethod.GET)
	public ModelAndView ListBillDetail(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			request.setAttribute("page", Integer.parseInt(session.getAttribute("page").toString()));
			session.removeAttribute("page");
			int idBill = Integer.parseInt(request.getParameter("idBill").toString());
			mav = new ModelAndView("admin/bill/list-detail");
			mav.addObject("billDetail", billServiceImpl.getBillDetailByIdUserLogin(idBill));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}

}
