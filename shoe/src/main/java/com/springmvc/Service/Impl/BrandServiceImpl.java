package com.springmvc.Service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.BrandRepository;
import com.springmvc.Entity.Brand;
import com.springmvc.Service.BrandService;
/**
 * @author PhamMinhThien
 * @since 2022
 **/
@Service
public class BrandServiceImpl implements BrandService{
	final static Logger logger = Logger.getLogger(BrandServiceImpl.class);
	@Autowired
	private BrandRepository brandRepository;
	/**
	 * getAllBrand
	 * @return List<Brand> listBrand
	 * @throws Exception
	 **/
	public List<Brand> getAllBrand() throws Exception{
		List<Brand> listBrand = null;
		try {
			listBrand = brandRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return listBrand;
	}
}
