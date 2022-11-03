package com.springmvc.Services;

import java.util.List;

import com.springmvc.Dto.SlideDto;

public interface ISlideService {
	List<SlideDto> getAllSlide() throws Exception;
}
