package com.springmvc.Service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.SlideRepository;
import com.springmvc.Entity.Slide;
import com.springmvc.Service.SlideService;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class SlideServiceImpl implements SlideService{
	final static Logger logger = Logger.getLogger(SlideServiceImpl.class);
	@Autowired
	private SlideRepository slideRepository;
	/**
	 * getAllSlide
	 * @return List<Slide> listSile
	 * @throws Exception
	 **/
	public List<Slide> getAllSlide() throws Exception {
		List<Slide> listSile = null;
		try {
			listSile = slideRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listSile;
	}
}
