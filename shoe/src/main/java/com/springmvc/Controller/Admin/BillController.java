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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Dto.BillDto;
import com.springmvc.Services.IBillService;
import com.springmvc.Utils.VerSign;

@Controller("AdminBill")
public class BillController {
	
	final static Logger logger = Logger.getLogger(BillController.class);
	
	@Autowired
	private IBillService billService;
	
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
			Page<BillDto> page = billService.getAllBill(pageable);
			List<BillDto> listPageBills = page.getContent();
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
	@GetMapping("/quan-tri/verify/{id}")
	public ModelAndView verify(@PathVariable String id, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			int idBill = Integer.parseInt(id);
			BillDto billDto = billService.findOne(idBill);
			if (VerSign.VerSignByHash(billDto.getSign(), billDto.getData(), billDto.getPubkey()) == true || VerSign.VerSignByFile(billDto.getSign(), billDto.getFile(), billDto.getPubkey()) == true) {
				billDto.setStatus("Đang giao hàng");
				billService.editBill(idBill,billDto );
			mav = new ModelAndView("redirect:/quan-tri/bill");
			}else {
				mav.addObject("err","Xét duyện thất bại");
				mav = new ModelAndView("redirect:/quan-tri/bill");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	@GetMapping("/quan-tri/bill-detail/{id}")
	public ModelAndView ListBillDetail(@PathVariable String id, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			request.setAttribute("page", Integer.parseInt(session.getAttribute("page").toString()));
			session.removeAttribute("page");
			int idBill = Integer.parseInt(id);
			mav = new ModelAndView("admin/bill/list-detail");
			mav.addObject("billDetail", billService.getBillDetailByIdUserLogin(idBill));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return mav;
	}
	

}
