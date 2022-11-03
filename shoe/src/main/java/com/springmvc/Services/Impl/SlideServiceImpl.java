package com.springmvc.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Converter.SlideConverter;
import com.springmvc.Dto.SlideDto;
import com.springmvc.Entity.SlideEntity;
import com.springmvc.Repositories.ISlideRepository;
import com.springmvc.Services.ISlideService;

@Service
public class SlideServiceImpl implements ISlideService {
	final static Logger logger = Logger.getLogger(SlideServiceImpl.class);
	@Autowired
	private ISlideRepository slideRepository;

	public List<SlideDto> getAllSlide() throws Exception {
		List<SlideDto> listSileDto = new ArrayList<SlideDto>();
		try {
			List<SlideEntity> listSlideEntity = slideRepository.findAll();
			for (SlideEntity slideEntity : listSlideEntity) {
				SlideDto slideDto = SlideConverter.toDto(slideEntity);
				listSileDto.add(slideDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listSileDto;
	}
}
