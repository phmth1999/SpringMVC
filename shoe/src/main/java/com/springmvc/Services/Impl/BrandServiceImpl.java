package com.springmvc.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Converter.BrandConverter;
import com.springmvc.Dto.BrandDto;
import com.springmvc.Entity.BrandEntity;
import com.springmvc.Repositories.IBrandRepository;
import com.springmvc.Services.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService {
	final static Logger logger = Logger.getLogger(BrandServiceImpl.class);
	@Autowired
	private IBrandRepository brandRepository;

	public List<BrandDto> getAllBrand() throws Exception {
		List<BrandDto> listBrandDto = new ArrayList<BrandDto>();
		try {
			List<BrandEntity> listBrandEntity = brandRepository.findAll();
			for (BrandEntity brandEntity : listBrandEntity) {
				BrandDto brandDto = BrandConverter.toDto(brandEntity);
				listBrandDto.add(brandDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBrandDto;
	}
}
