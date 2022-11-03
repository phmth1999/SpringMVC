package com.springmvc.Services;

import java.util.List;

import com.springmvc.Dto.BrandDto;

public interface IBrandService {
	List<BrandDto> getAllBrand() throws Exception;
}
