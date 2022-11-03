package com.springmvc.Converter;

import com.springmvc.Dto.BillDetailDto;
import com.springmvc.Entity.BillDetailEntity;

public class BillDetailConverter {
	public static BillDetailDto toDto(BillDetailEntity billDetailEntity) {
		BillDetailDto billDetailDto = new BillDetailDto();
		billDetailDto.setId(billDetailEntity.getId());
		billDetailDto.setId_product(billDetailEntity.getId_product());
		billDetailDto.setId_bill(billDetailEntity.getId_bill());
		billDetailDto.setQuanty(billDetailEntity.getQuanty());
		billDetailDto.setTotal(billDetailEntity.getTotal());
		return billDetailDto;
	}

	public static BillDetailEntity toEntity(BillDetailDto billDetailDto) {
		BillDetailEntity billDetailEntity = new BillDetailEntity();
		billDetailEntity.setId_product(billDetailDto.getId_product());
		billDetailEntity.setId_bill(billDetailDto.getId_bill());
		billDetailEntity.setQuanty(billDetailDto.getQuanty());
		billDetailEntity.setTotal(billDetailDto.getTotal());
		return billDetailEntity;
	}
}
