package com.springmvc.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
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
	public ModelAndView ListBill(HttpServletRequest request) {
		List<Bill> listBill = billServiceImpl.getAllDataBillSortDESC();
		PagedListHolder<Bill> pagedListHolder = new PagedListHolder<Bill>(listBill);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(6);
		ModelAndView mav = new ModelAndView("admin/bill/list");
		mav.addObject("pagedListHolder", pagedListHolder);
		return mav;
	}

}
