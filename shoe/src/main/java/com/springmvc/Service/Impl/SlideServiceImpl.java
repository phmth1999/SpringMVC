package com.springmvc.Service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Entity.SlideEntity;
import com.springmvc.Repositories.SlideRepository;
import com.springmvc.Service.SlideService;
@Service
public class SlideServiceImpl implements SlideService{
	final static Logger logger = Logger.getLogger(SlideServiceImpl.class);
	@Autowired
	private SlideRepository slideRepository;
	public List<SlideEntity> getAllSlide() throws Exception {
		List<SlideEntity> listSile = null;
		try {
			listSile = slideRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listSile;
	}
}
